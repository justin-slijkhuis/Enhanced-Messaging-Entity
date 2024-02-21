package eme.api.json.message.receive.zero.general;

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
