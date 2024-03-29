package eme.api.json.message.receive.zero.general;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0MuteConfig {

	@JsonProperty("selected_time_window")
	long selectedTimeWindow;

	@JsonProperty("end_time")
	Date endTime;
}
