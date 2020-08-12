package api.longpoll.bots.converters.doc;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.document.DocsSearchResponse;
import com.google.gson.JsonObject;

public class DocsSearchResponseConverterImpl extends JsonToPojoConverter<DocsSearchResponse> {
	@Override
	public DocsSearchResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, DocsSearchResponse.class);
	}
}
