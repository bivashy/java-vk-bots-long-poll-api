package api.longpoll.bots.converters.events.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.AttachmentConverterImpl;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryAttachmentsResponse;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MessagesGetHistoryAttachmentsResultConverterImpl extends JsonToPojoConverter<GenericResult<MessagesGetHistoryAttachmentsResponse>> {
    private static final String RESPONSE_FIELD = "response";
    private static final String ITEMS_FIELD = "items";
    private static final String ATTACHMENT_FIELD = "attachment";

    private AttachmentConverterImpl attachmentConverter = new AttachmentConverterImpl();

    @Override
    public GenericResult<MessagesGetHistoryAttachmentsResponse> convert(JsonObject jsonObject) {
        GenericResult<MessagesGetHistoryAttachmentsResponse> result = gson.fromJson(jsonObject, new TypeToken<GenericResult<MessagesGetHistoryAttachmentsResponse>>(){}.getType());

        List<MessagesGetHistoryAttachmentsResponse.Item> items = result.getResponse().getItems();
        JsonArray jsonItems = jsonObject.getAsJsonObject(RESPONSE_FIELD).getAsJsonArray(ITEMS_FIELD);
        for (int i = 0; i < jsonItems.size(); i++) {
            JsonObject jsonAttachment = jsonItems.get(i)
                    .getAsJsonObject()
                    .getAsJsonObject(ATTACHMENT_FIELD);
            items.get(i).setAttachment(attachmentConverter.convert(jsonAttachment));
        }

        return result;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Attachment.class.equals(fieldAttributes.getDeclaredClass());
    }
}
