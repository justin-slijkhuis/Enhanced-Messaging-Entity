package eme.api.json.message.send;

import eme.api.json.message.send.six.DiscordResumeData;
import lombok.Data;

@Data
public class DiscordOp6 {
    
    private int op = 6;

    private DiscordResumeData d = new DiscordResumeData();

    public DiscordOp6(String token, String sessionId, int sequence) {
        this.d.setToken(token);
        this.d.setSessionId(sessionId);
        this.d.setSequence(sequence);
    }
}
