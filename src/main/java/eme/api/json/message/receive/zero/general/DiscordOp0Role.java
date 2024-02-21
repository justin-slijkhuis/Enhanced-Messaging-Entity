package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Role {

    @JsonProperty("version")
    long version;

    @JsonProperty("unicode_emoji")
    String unicodeEmoji;

    // TODO: Fix
    // @JsonProperty( "tags" )
    // DiscordOp0DTags tags;

    @JsonProperty("position")
    long position;

    @JsonProperty("permissions")
    String permissions;

    @JsonProperty("name")
    String name;

    @JsonProperty("mentionable")
    boolean mentionable;

    @JsonProperty("managed")
    boolean managed;

    @JsonProperty("id")
    String id;

    @JsonProperty("icon")
    String icon;

    @JsonProperty("hoist")
    boolean hoist;

    @JsonProperty("flags")
    long flags;

    @JsonProperty("color")
    long color;
}
