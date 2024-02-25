package eme.api.json.message.receive.zero;

import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.message.receive.DiscordOp0;
import eme.api.json.message.receive.zero.general.DiscordOp0UserInfo;
import eme.worker.Worker;

public class DiscordOp0PresenceUpdate extends DiscordOp0 {

    DiscordOp0UserInfo d;
    
    public void execute(Worker worker, WebSocket webSocket) {
    }
}
