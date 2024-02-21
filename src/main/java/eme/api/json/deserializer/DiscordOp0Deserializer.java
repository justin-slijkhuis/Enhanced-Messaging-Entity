package eme.api.json.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import eme.api.json.message.receive.zero.sub.DiscordOp0ReadyElement;

public class DiscordOp0Deserializer extends JsonDeserializer<DiscordOp0ReadyElement[]> {
    @Override
	public DiscordOp0ReadyElement[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		
		JsonNode node = p.getCodec().readTree( p );
		if ( node.isArray() ) {
			return p.getCodec().treeToValue( node, DiscordOp0ReadyElement[].class );
		} else {
			return new DiscordOp0ReadyElement[]{ p.getCodec().treeToValue( node, DiscordOp0ReadyElement.class ) };
		}
	}
}
