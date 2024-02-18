package eme.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Discord2FAResponse {
    
    @JsonProperty( "ticket" )
	private String ticket;

    @JsonProperty( "mfa" )
    private boolean mfa;
	
	@JsonProperty( "user_id" )
	private String userId;

    @JsonProperty( "sms" )
    private boolean sms;

    @JsonProperty( "backup" )
    private boolean backup;

    @JsonProperty( "totp" )
    private boolean totp;

    
}
