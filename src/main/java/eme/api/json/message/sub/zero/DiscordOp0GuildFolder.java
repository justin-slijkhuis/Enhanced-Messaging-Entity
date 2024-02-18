package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0GuildFolder {

    @JsonProperty("name")
    String name;

    @JsonProperty("id")
    String id;

    @JsonProperty("guild_ids")
    String[] guildIds;

    @JsonProperty("color")
    String color;
}
