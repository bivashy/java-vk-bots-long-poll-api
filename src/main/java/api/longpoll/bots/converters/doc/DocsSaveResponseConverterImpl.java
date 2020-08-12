package api.longpoll.bots.converters.doc;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.document.DocsSaveResponse;
import com.google.gson.JsonObject;

public class DocsSaveResponseConverterImpl extends JsonToPojoConverter<DocsSaveResponse> {
	@Override
	public DocsSaveResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, DocsSaveResponse.class);
	}
}
