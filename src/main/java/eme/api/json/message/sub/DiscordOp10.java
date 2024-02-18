package eme.api.json.message.sub;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.DiscordIdentify;
import eme.api.json.message.DiscordMessage;
import eme.api.json.message.sub.ten.DiscordOp10Element;
import eme.worker.Worker;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
@JsonTypeName("10")
public class DiscordOp10 extends DiscordMessage {

    @JsonProperty("d")
    DiscordOp10Element d;

    public void execute(Worker worker, WebSocket webSocket) {
        DiscordIdentify identify = new DiscordIdentify(worker.getToken());

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
