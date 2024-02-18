package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0PrivateChannel {

    @JsonProperty("type")
    long type;

    @JsonProperty("recipients")
    DiscordOp0UserInfo[] recipients;

    @JsonProperty("last_message_id")
    String lastMessageId;

    @JsonProperty("is_spam")
    boolean isSpam;

    @JsonProperty("owner_id")
    String ownerId;

    @JsonProperty("name")
    String name;

    @JsonProperty("id")
    String id;

    @JsonProperty("icon")
    String icon;

    @JsonProperty("flags")
    long flags;
}
