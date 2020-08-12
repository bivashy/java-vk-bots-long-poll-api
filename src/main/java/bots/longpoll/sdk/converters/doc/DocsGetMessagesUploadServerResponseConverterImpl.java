package bots.longpoll.sdk.converters.doc;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.document.DocsGetMessagesUploadServerResponse;
import com.google.gson.JsonObject;

public class DocsGetMessagesUploadServerResponseConverterImpl extends JsonToPojoConverter<DocsGetMessagesUploadServerResponse> {
	@Override
	public DocsGetMessagesUploadServerResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, DocsGetMessagesUploadServerResponse.class);
	}
}
