package eme.api.json.message.send;

import lombok.Data;

@Data
public class DiscordOp1 {
    
    private int op = 1;

    private int d = 0;

    public DiscordOp1(int sequence) {
        this.d = sequence;
    }
}
