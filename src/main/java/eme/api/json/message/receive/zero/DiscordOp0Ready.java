package eme.api.json.message.receive.zero;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.deserializer.DiscordOp0Deserializer;
import eme.api.json.message.receive.DiscordOp0;
import eme.api.json.message.receive.zero.sub.DiscordOp0ReadyElement;
import eme.api.json.message.send.DiscordOp1;
import eme.worker.Worker;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@Data
@NoArgsConstructor
@JsonTypeName("READY")
public class DiscordOp0Ready extends DiscordOp0 {

    @JsonIgnore
    private static final Random RANDOM = new Random();

    @JsonIgnore
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    @JsonProperty("d")
    @JsonDeserialize(using = DiscordOp0Deserializer.class)
    DiscordOp0ReadyElement[] d;

    public void execute(Worker worker, WebSocket webSocket) {
        worker.setWorkerInfo(this);
        startHeartbeatInterval(webSocket, worker);
    }

    private static void startHeartbeatInterval(WebSocket webSocket, Worker worker) {
        Thread heartbeatThread = new Thread(() -> {
            try {
                Thread.sleep(worker.getHeartbeat() * (long) RANDOM.nextInt());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            sendHeartbeatMessage(webSocket, worker);

            while (webSocket.isOpen()) {
                try {
                    Thread.sleep(worker.getHeartbeat());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                sendHeartbeatMessage(webSocket, worker);
            }
        });

        heartbeatThread.setDaemon(true);
        heartbeatThread.start();
    }

    private static void sendHeartbeatMessage(WebSocket webSocket, Worker worker) {
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
}
