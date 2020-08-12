package api.longpoll.bots.converters.photo;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.photos.PhotosGetMessagesUploadServerResponse;
import com.google.gson.JsonObject;

public class PhotosGetMessagesUploadServerResponseConverterImpl extends JsonToPojoConverter<PhotosGetMessagesUploadServerResponse> {
	@Override
	public PhotosGetMessagesUploadServerResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, PhotosGetMessagesUploadServerResponse.class);
	}
}
