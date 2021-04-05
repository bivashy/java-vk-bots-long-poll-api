package api.longpoll.bots.converters.response.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.basic.MessageConverter;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryResponse;
import api.longpoll.bots.utils.converters.BulkConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class MessagesGetHistoryResultConverter extends JsonToPojoConverter<GenericResult<MessagesGetHistoryResponse>> {
    private static final JsonToPojoConverter<Message> MESSAGE_CONVERTER = new MessageConverter();

    @Override
    public GenericResult<MessagesGetHistoryResponse> convert(JsonObject jsonObject) {
        GenericResult<MessagesGetHistoryResponse> result = gson.fromJson(jsonObject, new TypeToken<GenericResult<MessagesGetHistoryResponse>>(){}.getType());
        result.getResponse().setItems(BulkConverterUtil.convert(jsonObject.getAsJsonObject("response").getAsJsonArray("items"), MESSAGE_CONVERTER));
        return result;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return "items".equals(fieldAttributes.getName());
    }
}
