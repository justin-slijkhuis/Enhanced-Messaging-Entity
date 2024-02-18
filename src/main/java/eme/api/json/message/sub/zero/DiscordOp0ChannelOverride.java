package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0ChannelOverride {

	@JsonProperty("muted")
	boolean muted;

	@JsonProperty("mute_config")
	DiscordOp0MuteConfig muteConfig;

	@JsonProperty("message_notifications")
	long messageNotifications;

	@JsonProperty("collapsed")
	boolean collapsed;

	@JsonProperty("channel_id")
	String channelId;
}
