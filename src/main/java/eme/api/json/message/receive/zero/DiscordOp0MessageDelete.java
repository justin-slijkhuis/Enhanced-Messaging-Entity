package eme.api.json.message.receive.zero;

import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.message.receive.DiscordOp0;
import eme.api.json.message.receive.zero.general.DiscordOp0Message;
import eme.worker.Worker;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
public class DiscordOp0MessageDelete extends DiscordOp0 {
    
    DiscordOp0Message d;
    
    public void execute(Worker worker, WebSocket webSocket) {
    }
}
