package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Emoji {

    @JsonProperty("version")
    long version;

    @JsonProperty("roles")
    String[] roles;

    @JsonProperty("require_colons")
    boolean requireColons;

    @JsonProperty("name")
    String name;

    @JsonProperty("managed")
    boolean managed;

    @JsonProperty("id")
    String id;

    @JsonProperty("available")
    boolean available;

    @JsonProperty("animated")
    boolean animated;
}
