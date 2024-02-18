package eme.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordIdentify {
    
    private int op = 2;

	private IdentifyValues d;

    public DiscordIdentify(String token) {
        this.d = new IdentifyValues();
        this.d.token = token;
    }

    @Data
    private static class IdentifyValues {
        @JsonProperty("token")
        private String token;

        @JsonProperty("intents")
        private int intents = 64128;

        @JsonProperty("properties")
        private IdentifyProperties properties = new IdentifyProperties();
        
        @Data
        private static class IdentifyProperties {

            @JsonProperty("os")
            private String os = "linux";
            
            @JsonProperty("browser")
            private String browser = "chrome";

            @JsonProperty("device")
            private String device = "chrome";
        }
    }
}
