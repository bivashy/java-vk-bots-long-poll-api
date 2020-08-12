package api.longpoll.bots.converters.photo;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.photos.Photo;
import com.google.gson.JsonObject;

public class PhotoConverterImpl extends JsonToPojoConverter<Photo> {
	@Override
	public Photo convert(JsonObject source) {
		return gson.fromJson(source, Photo.class);
	}
}
