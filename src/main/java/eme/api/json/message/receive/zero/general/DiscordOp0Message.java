package eme.api.json.message.receive.zero.general;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Message {

    @JsonProperty("type")
    long type;

    @JsonProperty("tts")
    boolean tts;

    @JsonProperty("timestamp")
    Date timestamp;

    @JsonProperty("pinned")
    boolean pinned;

    @JsonProperty("nonce")
    String nonce;

    @JsonProperty("mentions")
    DiscordOp0UserInfo[] mentions;

    @JsonProperty("mention_roles")
    String[] mentionRoles;

    @JsonProperty("mention_everyone")
    boolean mentionEveryone;

    @JsonProperty("id")
    String id;

    @JsonProperty("flags")
    long flags;

    @JsonProperty("embeds")
    DiscordOp0Embed[] embeds;

    @JsonProperty("edited_timestamp")
    Date editedTimestamp;

    @JsonProperty("content")
    String content;

    @JsonProperty("components")
    String[] components;

    @JsonProperty("channel_id")
    String channelId;

    @JsonProperty("author")
    DiscordOp0UserInfo author;

    @JsonProperty("attachments")
    String[] attachments;
}
