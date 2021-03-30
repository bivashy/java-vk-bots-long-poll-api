package api.longpoll.bots.converters.response.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.AttachmentConverter;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryAttachmentsResponse;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MessagesGetHistoryAttachmentsResultConverter extends JsonToPojoConverter<GenericResult<MessagesGetHistoryAttachmentsResponse>> {
    private static final JsonToPojoConverter<Attachment> ATTACHMENT_CONVERTER = new AttachmentConverter();

    @Override
    public GenericResult<MessagesGetHistoryAttachmentsResponse> convert(JsonObject jsonObject) {
        GenericResult<MessagesGetHistoryAttachmentsResponse> result = gson.fromJson(jsonObject, new TypeToken<GenericResult<MessagesGetHistoryAttachmentsResponse>>(){}.getType());

        List<MessagesGetHistoryAttachmentsResponse.Item> items = result.getResponse().getItems();
        JsonArray jsonItems = jsonObject.getAsJsonObject("response").getAsJsonArray("items");
        // TODO: 15.03.2021 make it beautiful
        for (int i = 0; i < jsonItems.size(); i++) {
            JsonObject jsonAttachment = jsonItems.get(i)
                    .getAsJsonObject()
                    .getAsJsonObject("attachment");
            items.get(i).setAttachment(ATTACHMENT_CONVERTER.convert(jsonAttachment));
        }

        return result;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Attachment.class.equals(fieldAttributes.getDeclaredClass());
    }
}
