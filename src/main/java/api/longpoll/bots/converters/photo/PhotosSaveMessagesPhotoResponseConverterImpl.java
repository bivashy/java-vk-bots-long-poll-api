package api.longpoll.bots.converters.photo;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.photos.PhotosSaveMessagesPhotoResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PhotosSaveMessagesPhotoResponseConverterImpl extends JsonToPojoConverter<PhotosSaveMessagesPhotoResponse> {
	private static final String RESPONSE_FIELD = "response";

	@Override
	public PhotosSaveMessagesPhotoResponse convert(JsonObject jsonObject) {
		JsonElement jsonElement = jsonObject.getAsJsonArray(RESPONSE_FIELD).get(0);
		return gson.fromJson(jsonElement, PhotosSaveMessagesPhotoResponse.class);
	}
}
