package bots.longpoll.sdk.converters.photo;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.photos.PhotoCommentDeleteUpdate;
import com.google.gson.JsonObject;

public class PhotoCommentDeleteUpdateConverterImpl extends JsonToPojoConverter<PhotoCommentDeleteUpdate> {
	@Override
	public PhotoCommentDeleteUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, PhotoCommentDeleteUpdate.class);
	}
}
