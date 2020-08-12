package api.longpoll.bots.converters.doc;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.document.Document;
import com.google.gson.JsonObject;

public class DocumentConverter extends JsonToPojoConverter<Document> {
	@Override
	public Document convert(JsonObject source) {
		return gson.fromJson(source, Document.class);
	}
}
