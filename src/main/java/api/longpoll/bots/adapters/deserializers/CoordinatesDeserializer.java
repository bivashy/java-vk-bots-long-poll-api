package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.model.objects.additional.Geo;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;

/**
 * Deserializes {@link Geo.Coordinates}.
 */
public class CoordinatesDeserializer implements JsonDeserializer<Geo.Coordinates> {
    @Override
    public Geo.Coordinates deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (jsonPrimitive.isString()) {
                String[] coordinatesStr = jsonPrimitive.getAsString().split("\\s+");

                Geo.Coordinates coordinates = new Geo.Coordinates();
                coordinates.setLatitude(Float.parseFloat(coordinatesStr[0]));
                coordinates.setLongitude(Float.parseFloat(coordinatesStr[1]));
                return coordinates;
            }
        }

        return jsonDeserializationContext.deserialize(jsonElement, type);
    }
}
