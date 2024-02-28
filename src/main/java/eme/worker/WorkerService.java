package eme.worker;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

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

    public void sendMessage(String channelId, String input) {
        DiscordContent message = new DiscordContent(input);
        // TODO: Implement typing delay
        Request.sendPostRequest(Urls.getChannelMessageUrl(channelId), message, worker.getToken());
    }

    public boolean handleMessageInput(String input, String sender, String channelId) {
        List<WorkerSettingsMessageLine> messages = Arrays.asList(worker.getSettings().getMessages());

        WorkerSettingsMessageLine line = messages.stream()
                .filter(message -> message.getInput().equals(input) && (message.isSelf() || !worker.getDiscordId().equals(sender)))
                .findFirst()
                .orElse(null);

        if (line == null) {
            return false;
        }

        sendMessage(channelId, line.getResponse());

        return true;
    }

    public boolean handleModuleInput(String input, String sender, String channelId) {
        List<Entry<WorkerSettingsModuleLine, WorkerModule>> returnedEntryList = worker.getModules().entrySet().stream()
                .filter(entry -> {
                    WorkerSettingsModuleLine moduleLine = entry.getKey();
                    WorkerModule workerModule = entry.getValue();

                    if (!moduleLine.isSelf() && worker.getDiscordId().equals(sender)) {
                        return false;
                    }

                    String commandStart = moduleLine.getCustomCommandStart() != null ? moduleLine.getCustomCommandStart() : worker.getSettings().getCommandStart();
                    String combinedInput = commandStart + workerModule.getInput(worker, sender);
                    return combinedInput.equals(input) || combinedInput.equals(commandStart + "FORCE");
                })
                .toList();

        if (returnedEntryList.isEmpty()) {
            return false;
        }

        returnedEntryList.forEach(entry -> sendMessage(channelId, entry.getValue().getResponse(worker, entry.getKey())));

        return true;
    }
}
