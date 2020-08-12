package bots.longpoll.sdk.converters.doc;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.document.DocsSaveResponse;
import com.google.gson.JsonObject;

public class DocsSaveResponseConverterImpl extends JsonToPojoConverter<DocsSaveResponse> {
	@Override
	public DocsSaveResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, DocsSaveResponse.class);
	}
}
