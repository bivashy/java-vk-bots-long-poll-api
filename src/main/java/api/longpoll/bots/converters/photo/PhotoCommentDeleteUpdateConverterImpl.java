package api.longpoll.bots.converters.photo;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.photos.PhotoCommentDeleteEvent;
import com.google.gson.JsonObject;

public class PhotoCommentDeleteUpdateConverterImpl extends JsonToPojoConverter<PhotoCommentDeleteEvent> {
	@Override
	public PhotoCommentDeleteEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, PhotoCommentDeleteEvent.class);
	}
}
