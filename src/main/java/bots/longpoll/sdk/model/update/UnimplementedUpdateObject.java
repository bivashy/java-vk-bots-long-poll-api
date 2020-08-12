package bots.longpoll.sdk.model.update;

import com.google.gson.JsonObject;

public class UnimplementedUpdateObject extends UpdateObject {
	private JsonObject jsonObject;

	public JsonObject getJsonObject() {
		return jsonObject;
	}

	public UnimplementedUpdateObject setJsonObject(JsonObject jsonObject) {
		this.jsonObject = jsonObject;
		return this;
	}
}
