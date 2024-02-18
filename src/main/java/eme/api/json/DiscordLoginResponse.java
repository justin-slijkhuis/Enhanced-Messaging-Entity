package eme.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import eme.api.json.sub.DiscordUserSettingsResponse;
import lombok.Data;

@Data
public class DiscordLoginResponse {
    
    @JsonProperty( "token" )
	private String token;
	
	@JsonProperty( "user_settings" )
	private DiscordUserSettingsResponse discordUserSettingsResponse;
	
	@JsonProperty( "user_id" )
	private String userId;
}
