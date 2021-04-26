package api.longpoll.bots.converters.events.messages;

import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.media.AttachmentType;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryAttachmentsResult;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessagesGetHistoryAttachmentsResultConverterTest {
    Gson gson = new Gson();

    @Test
    void messagesGetHistoryAttachments() {
        MessagesGetHistoryAttachmentsResult result = gson.fromJson(ParseUtil.readJson("json/response/messages_get_history_attachments/message_get_history_attachments_photo_sample_5_118.json"), MessagesGetHistoryAttachmentsResult.class);
        assertNotNull(result);

        MessagesGetHistoryAttachmentsResult.Response response = result.getResponse();
        assertNotNull(response);
        assertEquals("542/1", response.getNextFrom());

        List<MessagesGetHistoryAttachmentsResult.Response.Item> items = response.getItems();
        assertNotNull(items);
        assertFalse(items.isEmpty());

        MessagesGetHistoryAttachmentsResult.Response.Item item = items.get(0);
        assertNotNull(item);
        assertEquals(542, item.getMessageId());

        Attachment attachment = item.getAttachment();
        assertNotNull(attachment);
        assertEquals(AttachmentType.PHOTO, attachment.getType());
        assertNotNull(attachment.getAttachable());
    }
}