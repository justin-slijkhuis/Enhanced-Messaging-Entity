package eme.worker;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WorkerData {
    
    @JsonProperty("firstMessages")
    private String[] firstMessages = {};

    public void addFirstMessage(String sender) {
        String[] senders = Arrays.copyOf(firstMessages, firstMessages.length + 1);
        senders[senders.length - 1] = sender;
        this.firstMessages = senders;
    }
}
