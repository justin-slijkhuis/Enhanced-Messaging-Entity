package eme.api.json.message.sub.zero;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Channel {

    @JsonProperty("version")
    long version;

    @JsonProperty("type")
    long type;

    @JsonProperty("topic")
    String topic;

    @JsonProperty("rate_limit_per_user")
    long rateLimitPerUser;

    @JsonProperty("position")
    long position;

    @JsonProperty("permission_overwrites")
    DiscordOp0PermissionOverwrite[] permissionOverwrites;

    @JsonProperty("parent_id")
    String parentId;

    @JsonProperty("nsfw")
    boolean nsfw;

    @JsonProperty("name")
    String name;

    @JsonProperty("last_pin_timestamp")
    Date lastPinTimestamp;

    @JsonProperty("last_message_id")
    String lastMessageId;

    @JsonProperty("id")
    String id;

    @JsonProperty("flags")
    long flags;

    @JsonProperty("default_thread_rate_limit_per_user")
    long defaultThreadRateLimitPerUser;
}
