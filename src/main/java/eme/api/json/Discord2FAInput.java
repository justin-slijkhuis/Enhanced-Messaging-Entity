package eme.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Discord2FAInput {

    @JsonProperty( "code" )
	private String code;

    @JsonProperty( "login_source" )
    private static final String LOGIN_SOURCE = null;
    
    @JsonProperty( "gift_code_sku_id" )
    private static final String GIFT_CODE_SKU_ID = null;
    
    @JsonProperty( "ticket" )
	private String ticket;
}
