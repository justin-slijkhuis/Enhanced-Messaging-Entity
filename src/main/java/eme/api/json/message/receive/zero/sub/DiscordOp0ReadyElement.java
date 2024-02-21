package eme.api.json.message.receive.zero.sub;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import eme.api.json.message.receive.zero.general.DiscordOp0Activity;
import eme.api.json.message.receive.zero.general.DiscordOp0Attachment;
import eme.api.json.message.receive.zero.general.DiscordOp0Call;
import eme.api.json.message.receive.zero.general.DiscordOp0ChannelOverride;
import eme.api.json.message.receive.zero.general.DiscordOp0ClientInfo;
import eme.api.json.message.receive.zero.general.DiscordOp0ConnectedAccount;
import eme.api.json.message.receive.zero.general.DiscordOp0CustomStatus;
import eme.api.json.message.receive.zero.general.DiscordOp0Embed;
import eme.api.json.message.receive.zero.general.DiscordOp0Emoji;
import eme.api.json.message.receive.zero.general.DiscordOp0Guild;
import eme.api.json.message.receive.zero.general.DiscordOp0Member;
import eme.api.json.message.receive.zero.general.DiscordOp0Message;
import eme.api.json.message.receive.zero.general.DiscordOp0MuteConfig;
import eme.api.json.message.receive.zero.general.DiscordOp0Presence;
import eme.api.json.message.receive.zero.general.DiscordOp0PrivateChannel;
import eme.api.json.message.receive.zero.general.DiscordOp0ReadState;
import eme.api.json.message.receive.zero.general.DiscordOp0Relationship;
import eme.api.json.message.receive.zero.general.DiscordOp0Session;
import eme.api.json.message.receive.zero.general.DiscordOp0User;
import eme.api.json.message.receive.zero.general.DiscordOp0UserGuildSettings;
import eme.api.json.message.receive.zero.general.DiscordOp0UserInfo;
import eme.api.json.message.receive.zero.general.DiscordOp0UserSettings;
import eme.api.json.message.receive.zero.general.DiscordOp0VoiceState;
import lombok.Data;

@Data
public class DiscordOp0ReadyElement {

	@JsonProperty("v")
	long v;

	@JsonProperty("user_settings_proto")
	String userSettingsProto;

	@JsonProperty("user_settings")
	DiscordOp0UserSettings userSettings;

	@JsonProperty("user_guild_settings")
	DiscordOp0UserGuildSettings[] userGuildSettings;

	@JsonProperty("user")
	DiscordOp0User user;

	@JsonProperty("member")
	DiscordOp0Member member;

	@JsonProperty("tutorial")
	String tutorial;

	@JsonProperty("sessions")
	DiscordOp0Session[] sessions;

	@JsonProperty("session_type")
	String sessionType;

	@JsonProperty("session_id")
	String sessionId;

	@JsonProperty("resume_gateway_url")
	String resumeGatewayUrl;

	@JsonProperty("relationships")
	DiscordOp0Relationship[] relationships;

	@JsonProperty("read_state")
	DiscordOp0ReadState[] readStates;

	@JsonProperty("private_channels")
	DiscordOp0PrivateChannel[] privateChannels;

	@JsonProperty("presences")
	DiscordOp0Presence[] presences;

	@JsonProperty("guilds")
	DiscordOp0Guild[] guilds;

	@JsonProperty("country_code")
	String countryCode;

	@JsonProperty("connected_accounts")
	DiscordOp0ConnectedAccount[] connectedAccounts;

	@JsonProperty("custom_status")
	DiscordOp0CustomStatus customStatus;

	@JsonProperty("status")
	String status;

	@JsonProperty("voice_states")
	DiscordOp0VoiceState[] voiceStates;

	@JsonProperty("ringing")
	String[] ringing;

	@JsonProperty("region")
	String region;

	@JsonProperty("message_id")
	String messageId;

	@JsonProperty("client_info")
	DiscordOp0ClientInfo discordOp0DClientInfo;

	@JsonProperty("activities")
	DiscordOp0Activity[] activities;

	@JsonProperty("type")
	long type;

	@JsonProperty("tts")
	boolean tts;

	@JsonProperty("timestamp")
	Date timestamp;

	@JsonProperty("referenced_message")
	DiscordOp0Message referenceMessage;

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

	@JsonProperty("guild_id")
	String guildId;

	@JsonProperty("user_id")
	String userId;

	@JsonProperty("suppress")
	boolean suppress;

	@JsonProperty("self_video")
	boolean selfVideo;

	@JsonProperty("self_mute")
	boolean selfMute;

	@JsonProperty("self_deaf")
	boolean selfDeaf;

	@JsonProperty("request_to_speak_timestamp")
	Date requestToSpeakTimestamp;

	@JsonProperty("mute")
	boolean mute;

	@JsonProperty("deaf")
	boolean deaf;

	@JsonProperty("channel_id")
	String channelId;

	@JsonProperty("emoji")
	DiscordOp0Emoji emoji;

	@JsonProperty("call")
	DiscordOp0Call call;

	@JsonProperty("author")
	DiscordOp0UserInfo author;

	@JsonProperty("attachments")
	DiscordOp0Attachment[] attachments;

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

	@JsonProperty("channel_overrides")
	DiscordOp0ChannelOverride[] channelOverrides;
}
