package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0PermissionOverwrite {

    @JsonProperty("type")
    long type;

    @JsonProperty("id")
    String id;

    @JsonProperty("deny")
    String deny;

    @JsonProperty("allow")
    String allow;
}
