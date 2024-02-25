package eme.api.json.message.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.message.receive.ten.DiscordOp10Element;
import eme.api.json.message.send.DiscordOp2;
import eme.worker.Worker;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
public class DiscordOp10 extends DiscordMessage {

    @JsonProperty("d")
    DiscordOp10Element d;

    public void execute(Worker worker, WebSocket webSocket) {
        worker.setHeartbeat(d.getHeartbeatInterval());

        DiscordOp2 identify = new DiscordOp2(worker.getToken());

        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(identify);
        } catch (Exception e) {
            log.severe("Unable to convert identify to json for id: " + worker.getUuid());
            return;
        }

        webSocket.sendText(json);
    }
}
