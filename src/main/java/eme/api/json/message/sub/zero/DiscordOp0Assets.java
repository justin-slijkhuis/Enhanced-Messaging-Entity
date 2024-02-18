package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Assets {

    @JsonProperty("large_text")
    String largeText;

    @JsonProperty("large_image")
    String largeImage;
}
