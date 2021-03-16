package api.longpoll.bots.utils.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class GsonUtil {
    public static Stream<JsonElement> stream(JsonArray jsonArray) {
        return stream(jsonArray, false);
    }

    public static Stream<JsonElement> stream(JsonArray jsonArray, boolean parallel) {
        return StreamSupport.stream(jsonArray.spliterator(), parallel);
    }

    public static Type toType(Type mainType, Type... innerTypes) {
        return innerTypes.length > 0
                ? TypeToken.getParameterized(mainType, collectParameterized(innerTypes)).getType()
                : TypeToken.getParameterized(mainType, innerTypes).getType();
    }

    protected static Type collectParameterized(Type... types) {
        return collectParameterized(new LinkedList<>(Arrays.asList(types)));
    }

    protected static Type collectParameterized(LinkedList<Type> types) {
        return types.size() == 1
                ? TypeToken.getParameterized(types.getFirst()).getType()
                : TypeToken.getParameterized(types.removeFirst(), collectParameterized(types)).getType();
    }
}
