package eme.worker;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketFactory;

import eme.api.json.message.receive.DiscordOp0;
import eme.api.json.message.send.DiscordContent;
import eme.utils.Urls;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Getter
@RequiredArgsConstructor
public class Worker {
    
    private final String token;
    private final String uuid;
    private final WorkerSettings settings;

    private WebSocket webSocket;

    @Setter
    private String discordId;

    @Setter
    private DiscordOp0 workerInfo;

    @Setter
    private int heartbeat = 0;

    @Setter
    private int sequence = 0;

    private Timer continueTimer;

    private WorkerService workerService = new WorkerService(this);

    private List<WorkerModule> modules = new ArrayList<>();

    public void start() {
        try {
            webSocket = new WebSocketFactory().createSocket(Urls.getGatewayUrl());

            webSocket.addListener(new WorkerListener(this));

            webSocket.connect();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Failed to connect to gateway", e);
        }

        generateModules();
    }

    public void stop() {
        stopHeartbeatInterval();
        webSocket.disconnect();
    }

    public void startHeartbeatInterval() {
        continueTimer = new Timer();

        continueTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                workerService.sendHeartbeatMessage(webSocket);
            }
        }, 0, heartbeat);
    }

    public void stopHeartbeatInterval() {
        continueTimer.cancel();
        continueTimer.purge();
        continueTimer = null;
    }

    public void handleMessage(String channelId, String input, String sender) {
        String response = workerService.handleModuleInput(input, sender);

        if (response == null) {
            response = workerService.handleMessageInput(input, sender);
        }

        DiscordContent content = new DiscordContent(response);
        workerService.sendMessage(channelId, content);
    }

    public boolean checkDataFile() {
        File file = new File("src/main/java/eme/data/" + discordId + ".json");

        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (Exception e) {
                log.severe("Failed to create data file for id: " + discordId);
            }
        }

        return true;
    }

    private void generateModules() {
        List<WorkerSettingsModuleLine> moduleLines = Arrays.asList(settings.getModules());

        moduleLines.forEach(moduleLine -> {
            Class<? extends WorkerModule> module = WorkerModule.getModules().get(moduleLine.getName());

            if (module != null) {
                try {
                    Constructor<? extends WorkerModule> constructor = module.getDeclaredConstructor();
                    WorkerModule instance = constructor.newInstance();
                    instance.setDisabled(moduleLine.getDisabled());
                    modules.add(instance);
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to start work for module: " + moduleLine.getName());
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Module not found: " + moduleLine.getName());
            }
        });
    }
}
