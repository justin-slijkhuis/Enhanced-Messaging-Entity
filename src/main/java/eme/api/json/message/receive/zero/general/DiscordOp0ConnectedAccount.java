package eme.api.json.message.receive.zero.general;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscordOp0ConnectedAccount {

    @JsonProperty("visibility")
    long visibility;

    @JsonProperty("verified")
    boolean verified;

    @JsonProperty("type")
    String type;

    @JsonProperty("two_way_link")
    boolean twoWayLink;

    @JsonProperty("show_activity")
    boolean showActivity;

    @JsonProperty("revoked")
    boolean revoked;

    @JsonProperty("name")
    String name;

    @JsonProperty("metadata_visibility")
    long metadataVisibility;

    @JsonProperty("id")
    String id;

    @JsonProperty("friend_sync")
    boolean friendSync;

    @JsonProperty("access_token")
    String accessToken;
}
