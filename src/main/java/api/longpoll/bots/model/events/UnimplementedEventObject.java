package api.longpoll.bots.model.events;

import com.google.gson.JsonObject;

public class UnimplementedEventObject extends EventObject {
	private JsonObject jsonObject;

	public JsonObject getJsonObject() {
		return jsonObject;
	}

	public UnimplementedEventObject setJsonObject(JsonObject jsonObject) {
		this.jsonObject = jsonObject;
		return this;
	}
}

// TODO: 12.08.2020 decide wether delete this
