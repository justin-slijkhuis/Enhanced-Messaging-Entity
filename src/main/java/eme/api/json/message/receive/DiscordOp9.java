package eme.api.json.message.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.neovisionaries.ws.client.WebSocket;

import eme.worker.Worker;
import lombok.Data;

@Data
@JsonTypeName("0")
public class DiscordOp9 extends DiscordMessage {
    
    @JsonProperty( "op" )
	int op;
	
	@JsonProperty( "d" )
	boolean d;

    public void execute(Worker worker, WebSocket webSocket) {
        
    }
}
