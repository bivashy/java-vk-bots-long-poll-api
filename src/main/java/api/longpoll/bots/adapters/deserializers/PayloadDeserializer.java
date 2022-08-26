package api.longpoll.bots.adapters.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Deserializes JSON object to payload.
 */
public class PayloadDeserializer implements JsonDeserializer<JsonElement> {
    /**
     * {@link Gson} object.
     */
    private static final Gson GSON = new Gson();

    @Override
    public JsonElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        return jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()
                ? GSON.fromJson(jsonElement.getAsString(), JsonElement.class)
                : jsonElement;
    }
}
