package api.longpoll.bots.converters.other;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.other.AppPayload;
import com.google.gson.JsonObject;

public class AppPayloadConverterImpl extends JsonToPojoConverter<AppPayload> {
	@Override
	public AppPayload convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, AppPayload.class);
	}
}
