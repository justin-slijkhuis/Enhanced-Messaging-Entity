package eme.api.json.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.message.sub.DiscordOp0;
import eme.api.json.message.sub.DiscordOp10;
import eme.worker.Worker;
import lombok.Data;

@Data
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "op"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = DiscordOp0.class, name = "0"),
    @JsonSubTypes.Type(value = DiscordOp0.class, name = "9"),
    @JsonSubTypes.Type(value = DiscordOp10.class, name = "10"),
})
public abstract class DiscordMessage {

    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    @JsonProperty( "t" )
    private String t;

    @JsonProperty( "s" )
    private String s;

    @JsonProperty( "op" )
    private int op;

    public abstract void execute(Worker worker, WebSocket webSocket);
}
