package eme.api.json.message.sub.zero;

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
