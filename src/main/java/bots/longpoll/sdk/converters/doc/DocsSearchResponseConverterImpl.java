package bots.longpoll.sdk.converters.doc;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.document.DocsSearchResponse;
import com.google.gson.JsonObject;

public class DocsSearchResponseConverterImpl extends JsonToPojoConverter<DocsSearchResponse> {
	@Override
	public DocsSearchResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, DocsSearchResponse.class);
	}
}
