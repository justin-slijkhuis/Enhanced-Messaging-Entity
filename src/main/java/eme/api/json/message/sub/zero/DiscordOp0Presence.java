package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Presence {

    @JsonProperty("user")
    DiscordOp0UserInfo user;

    @JsonProperty("status")
    String status;

    @JsonProperty("last_modified")
    long lastModified;

    @JsonProperty("client_status")
    DiscordOp0ClientStatus clientStatus;

    @JsonProperty("activities")
    DiscordOp0Activity[] activities;
}
