package eme.api.json.message.send.two;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordIdentifyProperties {

    @JsonProperty("os")
    private String os = "linux";

    @JsonProperty("browser")
    private String browser = "chrome";

    @JsonProperty("device")
    private String device = "chrome";
}
