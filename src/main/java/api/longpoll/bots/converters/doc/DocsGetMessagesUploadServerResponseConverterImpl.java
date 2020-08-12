package api.longpoll.bots.converters.doc;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.document.DocsGetMessagesUploadServerResponse;
import com.google.gson.JsonObject;

public class DocsGetMessagesUploadServerResponseConverterImpl extends JsonToPojoConverter<DocsGetMessagesUploadServerResponse> {
	@Override
	public DocsGetMessagesUploadServerResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, DocsGetMessagesUploadServerResponse.class);
	}
}
