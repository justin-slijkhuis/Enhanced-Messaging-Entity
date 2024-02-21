package eme.api.json.message.receive.zero.general;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0Timestamps {

    @JsonProperty("start")
    Date start;

    @JsonProperty("end")
    Date end;
}
