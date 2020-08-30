package api.longpoll.bots.converters.events.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.AttachmentConverterImpl;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryAttachmentsResult;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class MessagesGetHistoryAttachmentsResultConverterImpl extends JsonToPojoConverter<MessagesGetHistoryAttachmentsResult> {
    private static final String RESPONSE_FIELD = "response";
    private static final String ITEMS_FIELD = "items";
    private static final String ATTACHMENT_FIELD = "attachment";

    private AttachmentConverterImpl attachmentConverter = new AttachmentConverterImpl();

    @Override
    public MessagesGetHistoryAttachmentsResult convert(JsonObject jsonObject) {
        MessagesGetHistoryAttachmentsResult result = gson.fromJson(jsonObject, MessagesGetHistoryAttachmentsResult.class);

        List<MessagesGetHistoryAttachmentsResult.Response.Item> items = result.getResponse().getItems();
        JsonArray jsonItems = jsonObject.getAsJsonObject(RESPONSE_FIELD).getAsJsonArray(ITEMS_FIELD);
        for (int i = 0, size = jsonItems.size(); i < size; ++i) {
            JsonObject jsonAttachment = jsonItems.get(i)
                    .getAsJsonObject()
                    .getAsJsonObject(ATTACHMENT_FIELD);
            items.get(0).setAttachment(attachmentConverter.convert(jsonAttachment));
        }

        return result;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Attachment.class.equals(fieldAttributes.getDeclaredClass());
    }
}
