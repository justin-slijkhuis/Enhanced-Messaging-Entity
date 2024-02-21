package eme.api.json.message.receive;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.message.receive.zero.DiscordOp0MessageCreate;
import eme.api.json.message.receive.zero.DiscordOp0MessageDelete;
import eme.api.json.message.receive.zero.DiscordOp0MessageUpdate;
import eme.api.json.message.receive.zero.DiscordOp0Ready;
import eme.worker.Worker;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonTypeName("0")
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "t"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = DiscordOp0Ready.class, name = "READY"),
    @JsonSubTypes.Type(value = DiscordOp0MessageCreate.class, name = "MESSAGE_CREATE"),
    @JsonSubTypes.Type(value = DiscordOp0MessageDelete.class, name = "MESSAGE_DELETE"),
    @JsonSubTypes.Type(value = DiscordOp0MessageUpdate.class, name = "MESSAGE_UPDATE"),
})
public abstract class DiscordOp0 extends DiscordMessage {

    public abstract void execute(Worker worker, WebSocket webSocket);
}
