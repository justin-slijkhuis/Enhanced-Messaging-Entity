package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Embed {

    @JsonProperty("video")
    DiscordOp0EmbedInfo video;

    @JsonProperty("url")
    String url;

    @JsonProperty("type")
    String type;

    @JsonProperty("title")
    String title;

    @JsonProperty("description")
    String description;

    @JsonProperty("thumbnail")
    DiscordOp0EmbedInfo thumbnail;

    @JsonProperty("provider")
    DiscordOp0Provider provider;
}
