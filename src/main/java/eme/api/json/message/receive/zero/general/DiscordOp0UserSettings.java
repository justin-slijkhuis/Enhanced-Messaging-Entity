package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0UserSettings {
	@JsonProperty("detect_platform_accounts")
	boolean detectPlatformAccounts;

	@JsonProperty("animate_stickers")
	long animateStickers;

	@JsonProperty("inline_attachment_media")
	boolean inlineAttachmentMedia;

	@JsonProperty("status")
	String status;

	@JsonProperty("message_display_compact")
	boolean messageDisplayCompact;

	@JsonProperty("view_nsfw_guilds")
	boolean viewNsfwGuilds;

	@JsonProperty("timezone_offset")
	long timezoneOffset;

	@JsonProperty("enable_tts_command")
	boolean enableTtsCommand;

	@JsonProperty("disable_games_tab")
	boolean disableGamesTab;

	@JsonProperty("stream_notifications_enabled")
	boolean streamNotificationsEnabled;

	@JsonProperty("animate_emoji")
	boolean animateEmoji;

	@JsonProperty("guild_folders")
	DiscordOp0GuildFolder[] guildFolders;

	@JsonProperty("activity_joining_restricted_guild_ids")
	String[] activityJoiningRestrictedGuildIds;

	@JsonProperty("friend_source_flags")
	DiscordOp0FriendSourceFlags friendSourceFlags;

	@JsonProperty("convert_emoticons")
	boolean convertEmoticons;

	@JsonProperty("afk_timeout")
	long afkTimeout;

	@JsonProperty("passwordless")
	boolean passwordless;

	@JsonProperty("contact_sync_enabled")
	boolean contactSyncEnabled;

	@JsonProperty("gif_auto_play")
	boolean gifAutoPlay;

	@JsonProperty("custom_status")
	DiscordOp0CustomStatus customStatus;

	@JsonProperty("native_phone_integration_enabled")
	boolean nativePhoneIntegrationEnabled;

	@JsonProperty("allow_accessibility_detection")
	boolean allowAccessibilityDetection;

	@JsonProperty( "friend_discovery_flags" )
	long friendDiscoveryFlags;

	@JsonProperty("show_current_game")
	boolean showCurrentGame;

	@JsonProperty("restricted_guilds")
	String[] restrictedGuilds;

	@JsonProperty("developer_mode")
	boolean developerMode;

	@JsonProperty("view_nsfw_commands")
	boolean viewNsfwCommands;

	@JsonProperty("render_reactions")
	boolean renderReactions;

	@JsonProperty("locale")
	String locale;

	@JsonProperty("render_embeds")
	boolean renderEmbeds;

	@JsonProperty("inline_embed_media")
	boolean inlineEmbedMedia;

	@JsonProperty("default_guilds_restricted")
	boolean defaultGuildsRestricted;

	@JsonProperty("explicit_content_filter")
	long explicitContentFilter;

	@JsonProperty("activity_restricted_guild_ids")
	String[] activityRestrictedGuildIds;

	@JsonProperty("theme")
	String theme;
}
