package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Session {

    @JsonProperty("status")
    String status;

    @JsonProperty("session_id")
    String sessionId;

    @JsonProperty("client_info")
    DiscordOp0ClientInfo clientInfo;

    @JsonProperty("activites")
    DiscordOp0Activity[] activities;
}
