package eme.worker;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import eme.api.json.message.DiscordMessage;
import lombok.extern.java.Log;

@Log
public class WorkerService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private WorkerService() {}
    
    public static DiscordMessage convertToDiscordMessage( String message ) {
        try {
            return OBJECT_MAPPER.readValue(message, DiscordMessage.class);
        } catch (Exception e) {
            log.severe(e.getMessage());
            log.severe("Unable to convert message to DiscordMessage");
            return null;
        }
    }
}
