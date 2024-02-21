package eme.api.json.message.receive.zero;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.message.receive.DiscordOp0;
import eme.api.json.message.receive.zero.general.DiscordOp0Message;
import eme.worker.Worker;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;


@Log
@Data
@NoArgsConstructor
@JsonTypeName("MESSAGE_UPDATE")
public class DiscordOp0MessageUpdate extends DiscordOp0 {

    DiscordOp0Message d;
    
    public void execute(Worker worker, WebSocket webSocket) {
        log.info(this.toString());
    }
}
