package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0ClientStatus {

    @JsonProperty("web")
    String web;

    @JsonProperty("mobile")
    String mobile;

    @JsonProperty("desktop")
    String desktop;
}
