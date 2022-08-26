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
public class SendResponseBodyDeserializer implements JsonDeserializer<Send.ResponseBody> {
    @Override
    public Send.ResponseBody deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonElement jsonResponse = jsonElement.getAsJsonObject().get("response");

        Send.ResponseBody responseBody = new Send.ResponseBody();
        responseBody.setResponse(deserializeResponse(jsonResponse, context));
        return responseBody;
    }

    private Object deserializeResponse(JsonElement jsonResponse, JsonDeserializationContext context) {
        return jsonResponse.isJsonPrimitive()
                ? jsonResponse.getAsInt()
                : context.deserialize(jsonResponse, TypeToken.getParameterized(List.class, Send.ResponseBody.Response.class).getType());
    }
}
