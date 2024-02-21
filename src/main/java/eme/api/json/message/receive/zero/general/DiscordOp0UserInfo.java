package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0UserInfo {

    @JsonProperty("username")
    String username;

    @JsonProperty("public_flags")
    long publicFlags;

    @JsonProperty("premium_type")
    long premiumType;

    @JsonProperty("id")
    String id;

    @JsonProperty("global_name")
    String globalName;

    @JsonProperty("discriminator")
    String discriminator;

    @JsonProperty("bot")
    boolean bot;

    // TODO: Fix type
    // @JsonProperty("avatar_decoration_data")
    // String avatarDecoration;

    @JsonProperty("avatar")
    String avatar;
}
