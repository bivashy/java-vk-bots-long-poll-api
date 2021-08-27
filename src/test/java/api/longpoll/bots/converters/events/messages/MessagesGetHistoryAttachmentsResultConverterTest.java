package api.longpoll.bots.converters.events.messages;

import api.longpoll.bots.methods.impl.messages.GetHistoryAttachments;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.media.AttachmentType;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MessagesGetHistoryAttachmentsResultConverterTest {
    Gson gson = new Gson();

    @Test
    void messagesGetHistoryAttachments() {
        GetHistoryAttachments.Response result = gson.fromJson(ParseUtil.readJson("json/response/messages_get_history_attachments/message_get_history_attachments_photo_sample_5_118.json"), GetHistoryAttachments.Response.class);
        assertNotNull(result);

        GetHistoryAttachments.Response.ResponseObject response = result.getResponseObject();
        assertNotNull(response);
        assertEquals("542/1", response.getNextFrom());

        List<GetHistoryAttachments.Response.ResponseObject.Item> items = response.getItems();
        assertNotNull(items);
        assertFalse(items.isEmpty());

        GetHistoryAttachments.Response.ResponseObject.Item item = items.get(0);
        assertNotNull(item);
        assertEquals(542, item.getMessageId());

        Attachment attachment = item.getAttachment();
        assertNotNull(attachment);
        assertEquals(AttachmentType.PHOTO, attachment.getType());
        assertNotNull(attachment.getAttachable());
    }
}