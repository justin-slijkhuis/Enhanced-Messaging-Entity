package eme.api.json.message.receive.zero.general;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Call {

    @JsonProperty("participants")
    String[] participants;

    @JsonProperty("ended_timestamp")
    Date endedTimestamp;
}
