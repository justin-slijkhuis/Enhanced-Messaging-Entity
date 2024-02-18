package eme.api.json.message.sub.zero;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0ReadState {

    @JsonProperty("mention_count")
    long mentionCount;

    @JsonProperty("last_pin_timestamp")
    Date lastPinTimestamp;

    @JsonProperty("last_message_id")
    String lastMessageId;

    @JsonProperty("id")
    String id;
}
