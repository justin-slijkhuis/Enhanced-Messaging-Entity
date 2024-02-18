package eme.api.json.message.sub.ten;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp10Element {

    @JsonProperty("heartbeat_interval")
    int heartbeatInterval;

    @JsonProperty("_trace")
    String[] trace;
}
