package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Activity {

    @JsonProperty("type")
    long type;

    @JsonProperty("timestamps")
    DiscordOp0Timestamps timestamps;

    @JsonProperty("sync_id")
    String syncId;

    @JsonProperty("state")
    String state;

    @JsonProperty("session_id")
    String sessionId;

    @JsonProperty("party")
    DiscordOp0Party party;

    @JsonProperty("name")
    String name;

    @JsonProperty("id")
    String id;

    @JsonProperty("flags")
    long flags;

    @JsonProperty("details")
    String details;

    @JsonProperty("created_at")
    long createdAt;

    @JsonProperty("application_id")
    String applicationId;

    @JsonProperty("assets")
    DiscordOp0Assets assets;
}
