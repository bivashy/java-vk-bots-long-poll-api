package api.longpoll.bots.adapters.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Deserializes Integer JSON value to {@code Boolean}. (0 = false, 1 = true)
 */
public class BoolIntDeserializer implements JsonDeserializer<Boolean> {
    @Override
    public final Boolean deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return jsonElement.getAsInt() == 1;
    }
}
