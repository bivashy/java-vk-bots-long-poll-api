package bots.longpoll.sdk.converters.photo;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.photos.PhotosGetMessagesUploadServerResponse;
import com.google.gson.JsonObject;

public class PhotosGetMessagesUploadServerResponseConverterImpl extends JsonToPojoConverter<PhotosGetMessagesUploadServerResponse> {
	@Override
	public PhotosGetMessagesUploadServerResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, PhotosGetMessagesUploadServerResponse.class);
	}
}
