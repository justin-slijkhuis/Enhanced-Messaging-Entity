package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Sticker {

    @JsonProperty("version")
    long version;

    @JsonProperty("type")
    long type;

    @JsonProperty("tags")
    String tags;

    @JsonProperty("name")
    String name;

    @JsonProperty("id")
    String id;

    @JsonProperty("guild_id")
    String guildId;

    @JsonProperty("format_type")
    long formatType;

    @JsonProperty("description")
    String description;

    @JsonProperty("available")
    boolean available;
}
