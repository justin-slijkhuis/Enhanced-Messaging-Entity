package eme.api.json.message.sub.zero;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0CustomStatus {

    @JsonProperty("text")
    String text;

    @JsonProperty("expires_at")
    Date expiresAt;

    @JsonProperty("emoji_name")
    String emojiName;

    @JsonProperty("emoji_id")
    long emojiId;
}
