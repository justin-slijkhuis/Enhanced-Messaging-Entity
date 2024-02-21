package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Provider {

    @JsonProperty("url")
    String url;

    @JsonProperty("name")
    String name;
}
