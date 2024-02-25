package eme.api.json.message.receive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neovisionaries.ws.client.WebSocket;

import eme.worker.Worker;
import lombok.Data;

@Data
public abstract class DiscordMessage {

    @JsonIgnore
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    @JsonProperty( "t" )
    private String t;

    @JsonProperty( "s" )
    private String s;

    @JsonProperty( "op" )
    private int op;

    public abstract void execute(Worker worker, WebSocket webSocket);
}
