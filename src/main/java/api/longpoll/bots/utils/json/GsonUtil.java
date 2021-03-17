package api.longpoll.bots.utils.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class GsonUtil {
    public static Stream<JsonElement> stream(JsonArray jsonArray) {
        return stream(jsonArray, false);
    }

    public static Stream<JsonElement> stream(JsonArray jsonArray, boolean parallel) {
        return StreamSupport.stream(jsonArray.spliterator(), parallel);
    }
}
