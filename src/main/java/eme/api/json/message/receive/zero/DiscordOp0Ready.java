package eme.api.json.message.receive.zero;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.neovisionaries.ws.client.WebSocket;

import eme.api.json.deserializer.DiscordOp0ReadyDeserializer;
import eme.api.json.message.receive.DiscordOp0;
import eme.api.json.message.receive.zero.sub.DiscordOp0ReadyElement;
import eme.worker.Worker;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
public class DiscordOp0Ready extends DiscordOp0 {

    @JsonIgnore
    private static final Random RANDOM = new Random();

    @JsonIgnore
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    @JsonProperty("d")
    @JsonDeserialize(using = DiscordOp0ReadyDeserializer.class)
    DiscordOp0ReadyElement[] d;

    public void execute(Worker worker, WebSocket webSocket) {
        log.info("Received READY for id: " + worker.getUuid());
        worker.setWorkerInfo(this);
        worker.setDiscordId(d[0].getUser().getId());
        worker.startHeartbeatInterval();
        worker.getWorkerDataService().validateFile();
    }
}
