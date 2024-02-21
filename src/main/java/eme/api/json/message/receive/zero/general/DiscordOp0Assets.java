package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Assets {

    @JsonProperty("large_text")
    String largeText;

    @JsonProperty("large_image")
    String largeImage;
}
