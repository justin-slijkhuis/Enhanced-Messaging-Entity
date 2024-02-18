package eme.api.json.message.sub.zero;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Member {

    @JsonProperty("user")
    DiscordOp0UserInfo user;

    @JsonProperty("roles")
    String[] roles;

    @JsonProperty("premium_since")
    Date premiumSince;

    @JsonProperty("pending")
    boolean pending;

    @JsonProperty("nick")
    String nick;

    @JsonProperty("mute")
    boolean mute;

    @JsonProperty("joined_at")
    Date joinedAt;

    @JsonProperty("flags")
    long flags;

    @JsonProperty("deaf")
    boolean deaf;

    @JsonProperty("communication_disabled_until")
    Date communicationDisabledUntil;

    @JsonProperty("avatar")
    String avatar;
}
