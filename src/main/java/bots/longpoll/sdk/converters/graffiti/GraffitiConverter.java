package bots.longpoll.sdk.converters.graffiti;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.graffiti.Graffiti;
import com.google.gson.JsonObject;

public class GraffitiConverter extends JsonToPojoConverter<Graffiti> {
	@Override
	public Graffiti convert(JsonObject source) {
		return gson.fromJson(source, Graffiti.class);
	}
}
