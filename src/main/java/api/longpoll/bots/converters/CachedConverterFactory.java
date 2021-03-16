package api.longpoll.bots.converters;

import api.longpoll.bots.utils.json.GsonUtil;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class CachedConverterFactory {
    private static final Map<Type, JsonToPojoConverter<?>> CONVERTERS = new HashMap<>();

    public static <T> JsonToPojoConverter<T> getConverter(Type targetRawType, Type... targetTypeArguments) {
        Type type = GsonUtil.toType(targetRawType, targetTypeArguments);
        return (JsonToPojoConverter<T>) CONVERTERS.computeIfAbsent(type, CachedConverterFactory::getConverter);
    }

    protected static <T> JsonToPojoConverter<T> getConverter(Type type) {
        return new JsonToPojoConverter<T>() {
            @Override
            public T convert(JsonObject jsonObject) {
                return gson.fromJson(jsonObject, type);
            }
        };
    }
}
