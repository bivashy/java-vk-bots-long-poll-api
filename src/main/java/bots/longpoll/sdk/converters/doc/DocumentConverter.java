package bots.longpoll.sdk.converters.doc;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.document.Document;
import com.google.gson.JsonObject;

public class DocumentConverter extends JsonToPojoConverter<Document> {
	@Override
	public Document convert(JsonObject source) {
		return gson.fromJson(source, Document.class);
	}
}
