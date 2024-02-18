package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0UserInfo {

    @JsonProperty("username")
    String username;

    @JsonProperty("public_flags")
    long publicFlags;

    @JsonProperty("id")
    String id;

    @JsonProperty("display_name")
    String displayName;

    @JsonProperty("discriminator")
    String discriminator;

    @JsonProperty("bot")
    boolean bot;

    @JsonProperty("avatar_decoration")
    String avatarDecoration;

    @JsonProperty("avatar")
    String avatar;
}
