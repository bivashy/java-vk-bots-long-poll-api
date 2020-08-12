package bots.longpoll.sdk.model.document;

import com.google.gson.annotations.SerializedName;

public class DocsSaveResponse {
	@SerializedName("type")
	private String type;
	@SerializedName("doc")
	private Document object;

	public String getType() {
		return type;
	}

	public DocsSaveResponse setType(String type) {
		this.type = type;
		return this;
	}

	public Document getObject() {
		return object;
	}

	public DocsSaveResponse setObject(Document object) {
		this.object = object;
		return this;
	}
}
