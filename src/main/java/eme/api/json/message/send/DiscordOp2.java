package eme.api.json.message.send;

import eme.api.json.message.send.two.DiscordIdentifyValues;
import lombok.Data;

@Data
public class DiscordOp2 {
    
    private int op = 2;

	private DiscordIdentifyValues d = new DiscordIdentifyValues();

    public DiscordOp2(String token) {
        this.d.setToken(token);
    }
}
