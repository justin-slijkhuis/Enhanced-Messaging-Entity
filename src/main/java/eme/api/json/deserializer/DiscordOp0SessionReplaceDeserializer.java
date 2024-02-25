package eme.api.json.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import eme.api.json.message.receive.zero.general.DiscordOp0Session;

public class DiscordOp0SessionReplaceDeserializer extends JsonDeserializer<DiscordOp0Session[]> {
    
    @Override
	public DiscordOp0Session[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree( p );

		if ( node.isArray() ) {
			return p.getCodec().treeToValue( node, DiscordOp0Session[].class );
		} else {
			return new DiscordOp0Session[]{ p.getCodec().treeToValue( node, DiscordOp0Session.class ) };
		}
    }
}
