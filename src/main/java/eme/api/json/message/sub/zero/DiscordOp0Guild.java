package eme.api.json.message.sub.zero;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Guild {
    
    @JsonProperty( "preferred_locale" )
			String preferredLocale;
			
			@JsonProperty( "stage_instances" )
			String[] stageInstances;
			
			@JsonProperty( "nsfw_level" )
			long nsfwLevel;
			
			@JsonProperty( "large" )
			boolean large;
			
			@JsonProperty( "premium_progress_bar_enabled" )
			boolean premiumProgressBarEnabled;
			
			@JsonProperty( "public_updates_channel_id" )
			String publicUpdatesChannelId;
			
			@JsonProperty( "application_id" )
			String applicationId;
			
			@JsonProperty( "members" )
			DiscordOp0Member[] members;
			
			@JsonProperty( "member_count" )
			long memberCount;
			
			@JsonProperty( "system_channel_id" )
			String systemChannelId;
			
			@JsonProperty( "safety_alerts_channel_id" )
			String safetyAlertsChannelId;
			
			@JsonProperty( "premium_tier" )
			long premiumTier;
			
			@JsonProperty( "lazy" )
			boolean lazy;
			
			@JsonProperty( "roles" )
			DiscordOp0Role[] roles;
			
			@JsonProperty( "voice_states" )
			DiscordOp0VoiceState[] voiceStates;
			
			@JsonProperty( "splash" )
			String splash;
			
			@JsonProperty( "icon" )
			String icon;
			
			@JsonProperty( "stickers" )
			DiscordOp0Sticker[] stickers;
			
			@JsonProperty( "afk_timeout" )
			long afkTimeout;
			
			@JsonProperty( "id" )
			String id;
			
			@JsonProperty( "presences" )
			DiscordOp0Presence[] presences;
			
			//			@JsonProperty( "guild_scheduled_events" )
			//			DiscordOp0DEvent[] scheduledEvents;
			
			@JsonProperty( "mfa_level" )
			long mfaLevel;
			
			@JsonProperty( "owner_id" )
			String ownerId;
			
			@JsonProperty( "max_video_channel_users" )
			long maxVideoChannelUsers;
			
			@JsonProperty( "region" )
			String region;
			
			@JsonProperty( "nsfw" )
			boolean nsfw;
			
			@JsonProperty( "max_stage_video_channel_users" )
			long maxStageVideoChannelUsers;
			
			@JsonProperty( "verification_level" )
			long verificationLevel;
			
			@JsonProperty( "afk_channel_id" )
			String afkChannelId;
			
			@JsonProperty( "rules_channel_id" )
			String rulesChannelId;
			
			@JsonProperty( "default_message_notifications" )
			long defaultMessageNotifications;
			
			@JsonProperty( "max_members" )
			long maxMembers;
			
			@JsonProperty( "vanity_url_code" )
			String vanityUrlCode;
			
			@JsonProperty( "emojis" )
			DiscordOp0Emoji[] emojis;
			
			@JsonProperty( "discover_splash" )
			String discoverySplash;
			
			@JsonProperty( "hub_type" )
			String hubType;
			
			@JsonProperty( "features" )
			String[] features;
			
			@JsonProperty( "premium_subscription_count" )
			long premiumSubscriptionCount;
			
			@JsonProperty( "banner" )
			String banner;
			
			@JsonProperty( "channels" )
			DiscordOp0Channel[] channels;
			
			@JsonProperty( "joined_at" )
			Date joinedAt;
			
			//			@JsonProperty( "embedded_activities" )
			//			DiscordOp0DEmbedActivity[] embeddedActivities;
			
			@JsonProperty( "home_header" )
			String homeHeader;
			
			@JsonProperty( "system_channel_flags" )
			long systemChannelFlags;
			
			@JsonProperty( "name" )
			String name;
			
			@JsonProperty( "description" )
			String description;
			
			@JsonProperty( "explicit_content_filter" )
			long explicitContentFilter;
}
