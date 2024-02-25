package eme.api.json.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import eme.api.json.message.receive.DiscordMessage;
import eme.api.json.message.receive.DiscordOp10;
import eme.api.json.message.receive.DiscordOp11;
import eme.api.json.message.receive.DiscordOp9;
import eme.api.json.message.receive.zero.DiscordOp0MessageCreate;
import eme.api.json.message.receive.zero.DiscordOp0MessageDelete;
import eme.api.json.message.receive.zero.DiscordOp0MessageUpdate;
import eme.api.json.message.receive.zero.DiscordOp0PresenceUpdate;
import eme.api.json.message.receive.zero.DiscordOp0Ready;
import eme.api.json.message.receive.zero.DiscordOp0SessionsReplace;

public class DiscordMessageDeserializer extends StdDeserializer<DiscordMessage> {
    
    public DiscordMessageDeserializer() {
        super(DiscordMessage.class);
    }

    @Override
    public DiscordMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);

        int op = node.get("op").asInt();
        String t = node.get("t").asText();

        switch (op) {
            case 0:
                switch (t) {
                    case "MESSAGE_CREATE":
                        return jp.getCodec().treeToValue(node, DiscordOp0MessageCreate.class);
                    case "MESSAGE_DELETE":
                        return jp.getCodec().treeToValue(node, DiscordOp0MessageDelete.class);
                    case "MESSAGE_UPDATE":
                        return jp.getCodec().treeToValue(node, DiscordOp0MessageUpdate.class);
                    case "PRESENCE_UPDATE":
                        return jp.getCodec().treeToValue(node, DiscordOp0PresenceUpdate.class);
                    case "READY":
                        return jp.getCodec().treeToValue(node, DiscordOp0Ready.class);
                    case "SESSIONS_REPLACE":
                        return jp.getCodec().treeToValue(node, DiscordOp0SessionsReplace.class);
                    default:
                        throw new IllegalArgumentException("Unknown t: " + t);
                }
            case 9:
                return jp.getCodec().treeToValue(node, DiscordOp9.class);
            case 10:
                return jp.getCodec().treeToValue(node, DiscordOp10.class);
            case 11:
                return jp.getCodec().treeToValue(node, DiscordOp11.class);
            default:
                throw new IllegalArgumentException("Unknown op code: " + op);
        }
    }
}
