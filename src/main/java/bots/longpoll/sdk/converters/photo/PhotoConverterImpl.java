package bots.longpoll.sdk.converters.photo;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.photos.Photo;
import com.google.gson.JsonObject;

public class PhotoConverterImpl extends JsonToPojoConverter<Photo> {
	@Override
	public Photo convert(JsonObject source) {
		return gson.fromJson(source, Photo.class);
	}
}
