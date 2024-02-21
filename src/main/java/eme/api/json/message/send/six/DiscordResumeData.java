package eme.api.json.message.send.six;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordResumeData {
    
    @JsonProperty("token")
    private String token;

    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("sequence")
    private int sequence;
}
