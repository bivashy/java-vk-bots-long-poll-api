package bots.longpoll.sdk.converters.doc;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.document.DocsGetWallUploadServerResponse;
import com.google.gson.JsonObject;

public class DocsGetWallUploadServerResponseConverterImpl extends JsonToPojoConverter<DocsGetWallUploadServerResponse> {
	@Override
	public DocsGetWallUploadServerResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, DocsGetWallUploadServerResponse.class);
	}
}
