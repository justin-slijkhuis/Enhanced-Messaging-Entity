package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Relationship {

    @JsonProperty("user")
    DiscordOp0UserInfo user;

    @JsonProperty("type")
    long type;

    @JsonProperty("nickname")
    String nickname;

    @JsonProperty("id")
    String id;
}
