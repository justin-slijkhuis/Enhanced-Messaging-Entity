package eme.api.json.message.send.two;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordIdentifyValues {

    @JsonProperty("token")
    private String token;

    @JsonProperty("intents")
    private int intents = 64128;

    @JsonProperty("properties")
    private DiscordIdentifyProperties properties = new DiscordIdentifyProperties();
}
