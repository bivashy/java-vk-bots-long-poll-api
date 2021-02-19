package api.longpoll.bots.converters;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CachedConverterFactory {
    private static final Map<Type, JsonToPojoConverter<?>> CONVERTERS = new HashMap<>();

    public static <T> JsonToPojoConverter<T> getConverter(Type targetRawType, Type... targetTypeArguments) {
        Type type = toType(targetRawType, targetTypeArguments);
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

    protected static Type toType(Type rawType, Type... typeArguments) {
        // TODO: 18.02.2021 https://github.com/google/gson/issues/1863
        // WA
        if (typeArguments.length > 0) {
            return TypeToken.getParameterized(rawType, collectParameterized(typeArguments)).getType();
        } else {
            return TypeToken.getParameterized(rawType, typeArguments).getType();
        }
    }

    protected static Type collectParameterized(Type... typeArguments) {
        return collectParameterized(new LinkedList<>(Arrays.asList(typeArguments)));
    }

    protected static Type collectParameterized(LinkedList<Type> types) {
        return types.size() == 1
                ? TypeToken.getParameterized(types.getFirst()).getType()
                : TypeToken.getParameterized(types.removeFirst(), collectParameterized(types)).getType();
    }
}
