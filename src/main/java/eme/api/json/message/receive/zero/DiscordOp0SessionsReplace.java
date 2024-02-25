package eme.api.json.message.receive.zero;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.deserializer.DiscordOp0SessionReplaceDeserializer;
import eme.api.json.message.receive.DiscordOp0;
import eme.api.json.message.receive.zero.general.DiscordOp0Session;
import eme.worker.Worker;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
public class DiscordOp0SessionsReplace extends DiscordOp0 {

    @JsonDeserialize(using = DiscordOp0SessionReplaceDeserializer.class)
    DiscordOp0Session[] d;
    
    public void execute(Worker worker, WebSocket webSocket) {
    }
}
