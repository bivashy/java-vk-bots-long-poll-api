package bots.longpoll.sdk.converters.likes;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.likes.LikeUpdate;
import com.google.gson.JsonObject;

public class LikeUpdateConverterImpl extends JsonToPojoConverter<LikeUpdate> {
	@Override
	public LikeUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, LikeUpdate.class);
	}
}
