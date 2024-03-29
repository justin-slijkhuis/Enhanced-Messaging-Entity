package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0ClientInfo {

    @JsonProperty("version")
    long version;

    @JsonProperty("os")
    String os;

    @JsonProperty("client")
    String client;
}
