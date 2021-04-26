package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.model.response.messages.MessagesSendResult;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Deserializes JSON object to {@link MessagesSendResult}.
 */
public class MessagesSendResultDeserializer implements JsonDeserializer<MessagesSendResult> {
    private static final Type RESPONSE_TYPE = new TypeToken<List<MessagesSendResult.Response>>() {}.getType();

    @Override
    public MessagesSendResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonResponse = jsonElement.getAsJsonObject().get("response");

        MessagesSendResult messagesSendResult = new MessagesSendResult();
        messagesSendResult.setResponse(
                jsonResponse.isJsonPrimitive()
                        ? jsonResponse.getAsInt()
                        : jsonDeserializationContext.deserialize(jsonResponse, RESPONSE_TYPE)
        );
        return messagesSendResult;
    }
}
