package eme.api.json.message;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import eme.api.json.message.sub.zero.DiscordOp0Element;

public class DiscordOp0Deserializer extends JsonDeserializer<DiscordOp0Element[]> {
    @Override
	public DiscordOp0Element[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		
		JsonNode node = p.getCodec().readTree( p );
		if ( node.isArray() ) {
			return p.getCodec().treeToValue( node, DiscordOp0Element[].class );
		} else {
			return new DiscordOp0Element[]{ p.getCodec().treeToValue( node, DiscordOp0Element.class ) };
		}
	}
}
