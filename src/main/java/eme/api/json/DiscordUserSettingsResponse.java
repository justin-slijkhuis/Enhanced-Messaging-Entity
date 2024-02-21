package eme.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DiscordUserSettingsResponse {
    
    @JsonProperty( "locale" )
	private String locale;
	
	@JsonProperty( "theme" )
	private String theme;
}
