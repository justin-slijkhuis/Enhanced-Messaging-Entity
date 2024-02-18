package eme.api.json.message.sub;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.message.DiscordMessage;
import eme.api.json.message.DiscordOp0Deserializer;
import eme.api.json.message.sub.zero.DiscordOp0Element;
import eme.worker.Worker;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
@JsonTypeName("0")
public class DiscordOp0 extends DiscordMessage {

    @JsonProperty("d")
    @JsonDeserialize(using = DiscordOp0Deserializer.class)
    DiscordOp0Element[] d;

    public void execute(Worker worker, WebSocket webSocket) {
        worker.setWorkerInfo(this);
        log.info(worker.getWorkerInfo().toString());
    }
}
