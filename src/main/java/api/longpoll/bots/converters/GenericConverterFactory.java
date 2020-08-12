package api.longpoll.bots.converters;

import com.google.gson.JsonObject;

public class GenericConverterFactory {
	public static <T> JsonToPojoConverter<T> get(Class<T> clazz) {
		return new JsonToPojoConverter<T>() {
			@Override
			public T convert(JsonObject jsonObject) {
				return gson.fromJson(jsonObject, clazz);
			}
		};
	}
}
