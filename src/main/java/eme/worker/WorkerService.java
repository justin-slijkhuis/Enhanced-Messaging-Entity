package eme.worker;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.deserializer.DiscordMessageDeserializer;
import eme.api.json.message.receive.DiscordMessage;
import eme.api.json.message.send.DiscordContent;
import eme.api.json.message.send.DiscordOp1;
import eme.utils.Request;
import eme.utils.Urls;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class WorkerService {

    private static final SimpleModule module = new SimpleModule().addDeserializer(DiscordMessage.class, new DiscordMessageDeserializer());
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).registerModule(module);

    private final Worker worker;
    
    public DiscordMessage convertToDiscordMessage(String message) {
        try {
            return OBJECT_MAPPER.readValue(message, DiscordMessage.class);
        } catch (Exception e) {
            log.severe(e.getMessage());
            log.severe("Unable to convert message to DiscordMessage");
            return null;
        }
    }

    public void sendHeartbeatMessage(WebSocket webSocket) {
        DiscordOp1 heartbeatMessage = new DiscordOp1(worker.getSequence());

        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(heartbeatMessage);
        } catch (Exception e) {
            log.warning("Unable to convert heartbeat to json for id: " + worker.getUuid());
            return;
        }

        webSocket.sendText(json);
        log.info("Sent heartbeat for id: " + worker.getUuid());
    }

    public void sendMessage(String channelId, DiscordContent message) {
        Request.sendPostRequest(Urls.getChannelMessageUrl(channelId), message, worker.getToken());
    }

    public String handleMessageInput(String input, String sender) {
        List<WorkerSettingsMessageLine> messages = Arrays.asList(worker.getSettings().getMessages());

        WorkerSettingsMessageLine line = messages.stream()
                .filter(message -> message.getInput().equals(input))
                .findFirst()
                .orElse(null);

        if (line != null && (line.isSelf() || !worker.getDiscordId().equals(sender))) {
            return line.getResponse();
        }

        return null;
    }

    public String handleModuleInput(String input, String sender) {
        if (sender.equals(worker.getDiscordId())) {
            return null;
        }

        WorkerModule messageModule = worker.getModules().stream()
                .filter(workerModule -> (worker.getSettings().getCommandStart() + workerModule.getInput()).equals(input))
                .findFirst()
                .orElse(null);

        if (messageModule != null) {
            return messageModule.getResponse(worker);
        }

        return null;
    }
}
