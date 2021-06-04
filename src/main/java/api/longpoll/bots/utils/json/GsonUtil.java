package api.longpoll.bots.utils.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Gson helper.
 */
public class GsonUtil {
    /**
     * Converts {@link JsonArray} to {@link Stream}.
     *
     * @param jsonArray JSON array.
     * @return stream of {@link JsonElement}
     */
    public static Stream<JsonElement> stream(JsonArray jsonArray) {
        return stream(jsonArray, false);
    }

    /**
     * Converts {@link JsonArray} to {@link Stream}.
     *
     * @param jsonArray JSON array.
     * @param parallel  <b>true</b> to make stream parallel.
     * @return stream of {@link JsonElement}
     */
    public static Stream<JsonElement> stream(JsonArray jsonArray, boolean parallel) {
        return StreamSupport.stream(jsonArray.spliterator(), parallel);
    }
}
