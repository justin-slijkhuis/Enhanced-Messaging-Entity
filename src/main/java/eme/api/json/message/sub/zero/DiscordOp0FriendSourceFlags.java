package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0FriendSourceFlags {

    @JsonProperty("all")
    boolean all;
}
