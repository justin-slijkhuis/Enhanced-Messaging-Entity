package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0UserGuildSettings {

    @JsonProperty("version")
    String version;

    @JsonProperty("suppress_roles")
    boolean suppressRoles;

    @JsonProperty("suppressEveryone")
    boolean suppressEveryone;

    @JsonProperty("notify_highlights")
    long notifyHighlights;

    @JsonProperty("muted")
    boolean muted;

    @JsonProperty("mute_scheduled_events")
    boolean muteScheduledEvents;

    @JsonProperty("mute_config")
    DiscordOp0MuteConfig muteConfig;

    @JsonProperty("mobile_push")
    boolean mobilePush;

    @JsonProperty("message_notifications")
    long messageNotifications;

    @JsonProperty("hide_muted_channels")
    boolean hideMutedChannels;

    @JsonProperty("guild_id")
    String guildId;

    @JsonProperty("flags")
    long flags;

    @JsonProperty("channel_overrides")
    DiscordOp0ChannelOverride[] channelOverrides;
}
