package eme.api.json.message.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neovisionaries.ws.client.WebSocket;

import eme.worker.Worker;
import lombok.Data;

@Data
public class DiscordOp9 extends DiscordMessage {
	
	@JsonProperty( "d" )
	boolean d;

    public void execute(Worker worker, WebSocket webSocket) {
        
    }
}
