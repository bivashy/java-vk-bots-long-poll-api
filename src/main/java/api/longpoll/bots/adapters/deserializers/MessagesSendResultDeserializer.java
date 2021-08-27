package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.methods.impl.messages.Send;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Deserializes JSON object to {@link Send.Response}.
 */
public class MessagesSendResultDeserializer implements JsonDeserializer<Send.Response> {
    private static final Type RESPONSE_TYPE = new TypeToken<List<Send.Response.ResponseObject>>() {}.getType();

    @Override
    public Send.Response deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonResponse = jsonElement.getAsJsonObject().get("response");

        Send.Response response = new Send.Response();
        response.setResponseObject(
                jsonResponse.isJsonPrimitive()
                        ? jsonResponse.getAsInt()
                        : jsonDeserializationContext.deserialize(jsonResponse, RESPONSE_TYPE)
        );
        return response;
    }
}
