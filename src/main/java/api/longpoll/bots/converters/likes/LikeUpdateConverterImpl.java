package api.longpoll.bots.converters.likes;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.likes.LikeEvent;
import com.google.gson.JsonObject;

public class LikeUpdateConverterImpl extends JsonToPojoConverter<LikeEvent> {
	@Override
	public LikeEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, LikeEvent.class);
	}
}
