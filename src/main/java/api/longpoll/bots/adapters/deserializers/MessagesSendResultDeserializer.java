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
 * Deserializes JSON object to {@link Send.ResponseBody}.
 */
public class MessagesSendResultDeserializer implements JsonDeserializer<Send.ResponseBody> {
    private static final Type RESPONSE_TYPE = new TypeToken<List<Send.ResponseBody.Response>>() {}.getType();

    @Override
    public Send.ResponseBody deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonResponse = jsonElement.getAsJsonObject().get("response");

        Send.ResponseBody response = new Send.ResponseBody();
        response.setResponse(
                jsonResponse.isJsonPrimitive()
                        ? jsonResponse.getAsInt()
                        : jsonDeserializationContext.deserialize(jsonResponse, RESPONSE_TYPE)
        );
        return response;
    }
}
