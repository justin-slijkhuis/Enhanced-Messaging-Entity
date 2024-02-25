package eme.api.json.message.receive;

import com.neovisionaries.ws.client.WebSocket;

import eme.worker.Worker;
import lombok.Data;

@Data
public abstract class DiscordOp0 extends DiscordMessage {

    public abstract void execute(Worker worker, WebSocket webSocket);
}
