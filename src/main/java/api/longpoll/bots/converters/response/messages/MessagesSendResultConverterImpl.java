package api.longpoll.bots.converters.response.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesSendResponse;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MessagesSendResultConverterImpl extends JsonToPojoConverter<GenericResult<Object>> {
    private static final String RESPONSE_FIELD = "response";

    @Override
    public GenericResult<Object> convert(JsonObject jsonObject) {
        GenericResult<Object> messagesSendResponse = gson.fromJson(jsonObject, new TypeToken<GenericResult<Object>>(){}.getType());
        JsonElement element = jsonObject.get(RESPONSE_FIELD);
        Object response = element.isJsonPrimitive()
                ? element.getAsInt()
                : gson.fromJson(element, new TypeToken<List<MessagesSendResponse>>() {}.getType());
        messagesSendResponse.setResponse(response);
        return messagesSendResponse;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Object.class.equals(fieldAttributes.getDeclaredClass());
    }
}
