package bots.longpoll.sdk.converters;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class StringToJsonConverterImpl implements Converter<String, JsonObject> {
	private static final String RESPONSE_FIELD = "response";

	@Override
	public JsonObject convert(String s) {
		JsonObject jsonObject = new Gson().fromJson(s, JsonObject.class);

		if (jsonObject.size() == 1 && jsonObject.has(RESPONSE_FIELD)) {
			jsonObject = jsonObject.getAsJsonObject(RESPONSE_FIELD);
		}

		return jsonObject;
	}
}
