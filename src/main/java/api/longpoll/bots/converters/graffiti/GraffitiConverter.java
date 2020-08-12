package api.longpoll.bots.converters.graffiti;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.graffiti.Graffiti;
import com.google.gson.JsonObject;

public class GraffitiConverter extends JsonToPojoConverter<Graffiti> {
	@Override
	public Graffiti convert(JsonObject source) {
		return gson.fromJson(source, Graffiti.class);
	}
}
