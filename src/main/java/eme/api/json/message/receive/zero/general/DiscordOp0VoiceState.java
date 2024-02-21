package eme.api.json.message.receive.zero.general;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0VoiceState {

    @JsonProperty("user_id")
    String userId;

    @JsonProperty("suppress")
    boolean suppress;

    @JsonProperty("session_id")
    String sessionId;

    @JsonProperty("self_video")
    boolean selfVideo;

    @JsonProperty("self_mute")
    boolean selfMute;

    @JsonProperty("self_deaf")
    boolean selfDeaf;

    @JsonProperty("request_to_speak_timestamp")
    Date requestToSpeakTimestamp;

    @JsonProperty("mute")
    boolean mute;

    @JsonProperty("deaf")
    boolean deaf;

    @JsonProperty("channel_id")
    String channelId;
}
