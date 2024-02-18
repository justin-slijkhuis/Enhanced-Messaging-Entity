package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Attachment {

    @JsonProperty("width")
    long width;

    @JsonProperty("url")
    String url;

    @JsonProperty("size")
    long size;

    @JsonProperty("id")
    String id;

    @JsonProperty("proxy_url")
    String proxyUrl;

    @JsonProperty("height")
    long height;

    @JsonProperty("filename")
    String filename;

    @JsonProperty("content_type")
    String contentType;
}
