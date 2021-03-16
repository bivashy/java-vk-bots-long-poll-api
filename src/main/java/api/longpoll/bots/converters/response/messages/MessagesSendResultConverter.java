package api.longpoll.bots.converters.response.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesSendResponse;
import api.longpoll.bots.utils.json.GsonUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MessagesSendResultConverter extends JsonToPojoConverter<GenericResult<Object>> {
    @Override
    public GenericResult<Object> convert(JsonObject jsonObject) {
        GenericResult<Object> messagesSendResponse = gson.fromJson(jsonObject, GsonUtil.toType(GenericResult.class, Object.class));
        JsonElement element = jsonObject.get("response");
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
