package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0EmbedInfo {

    @JsonProperty("width")
    long width;

    @JsonProperty("url")
    String url;

    @JsonProperty("proxy_url")
    String proxyUrl;

    @JsonProperty("height")
    long height;
}
