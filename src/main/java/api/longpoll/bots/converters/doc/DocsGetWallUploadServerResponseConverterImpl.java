package api.longpoll.bots.converters.doc;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.document.DocsGetWallUploadServerResponse;
import com.google.gson.JsonObject;

public class DocsGetWallUploadServerResponseConverterImpl extends JsonToPojoConverter<DocsGetWallUploadServerResponse> {
	@Override
	public DocsGetWallUploadServerResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, DocsGetWallUploadServerResponse.class);
	}
}
