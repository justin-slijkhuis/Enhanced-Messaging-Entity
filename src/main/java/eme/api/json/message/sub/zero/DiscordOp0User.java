package eme.api.json.message.sub.zero;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0User {

    @JsonProperty("verified")
    boolean verified;

    @JsonProperty("username")
    String username;

    @JsonProperty("purchased_flags")
    long purchasedFlags;

    @JsonProperty("premium_type")
    long premiumType;

    @JsonProperty("premium")
    boolean premium;

    @JsonProperty("phone")
    String phone;

    @JsonProperty("nsfw_allowed")
    boolean nsfwAllowed;

    @JsonProperty("mobile")
    boolean mobile;

    @JsonProperty("mfa_enabled")
    boolean mfaEnabled;

    @JsonProperty("id")
    String id;

    @JsonProperty("flags")
    long flags;

    @JsonProperty("email")
    String email;

    @JsonProperty("display_name")
    String displayName;

    @JsonProperty("discriminator")
    String discriminator;

    @JsonProperty("desktop")
    boolean desktop;

    @JsonProperty("bio")
    String bio;

    @JsonProperty("banner_color")
    String bannerColor;

    @JsonProperty("banner")
    String banner;

    @JsonProperty("avatar_decoration")
    String avatarDecoration;

    @JsonProperty("avatar")
    String avatar;

    @JsonProperty("accent_color")
    String accentColor;
}
