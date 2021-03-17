package api.longpoll.bots.converters;

import com.google.gson.JsonObject;

import java.lang.reflect.Type;

public class JsonToPojoConverterFactory {
    public static <T> JsonToPojoConverter<T> get(Type type) {
        return new JsonToPojoConverter<T>() {
            @Override
            public T convert(JsonObject jsonObject) {
                return gson.fromJson(jsonObject, type);
            }
        };
    }
}
