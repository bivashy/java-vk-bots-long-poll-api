package api.longpoll.bots.converters.events.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.response.messages.MessagesGetHistoryAttachmentsResultConverter;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.media.AttachmentType;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryAttachmentsResponse;
import org.junit.jupiter.api.Test;
import parse.response.ParseTestUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessagesGetHistoryAttachmentsResultConverterTest {
    JsonToPojoConverter<GenericResult<MessagesGetHistoryAttachmentsResponse>> converter = new MessagesGetHistoryAttachmentsResultConverter();

    @Test
    void messagesGetHistoryAttachments() {
        GenericResult<MessagesGetHistoryAttachmentsResponse> result = converter.convert(ParseTestUtil.readJson("json/response/messages_get_history_attachments/message_get_history_attachments_photo_sample_5_118.json"));
        assertNotNull(result);

        MessagesGetHistoryAttachmentsResponse response = result.getResponse();
        assertNotNull(response);
        assertEquals("542/1", response.getNextFrom());

        List<MessagesGetHistoryAttachmentsResponse.Item> items = response.getItems();
        assertNotNull(items);
        assertFalse(items.isEmpty());

        MessagesGetHistoryAttachmentsResponse.Item item = items.get(0);
        assertNotNull(item);
        assertEquals(542, item.getMessageId());

        Attachment attachment = item.getAttachment();
        assertNotNull(attachment);
        assertEquals(AttachmentType.PHOTO, attachment.getType());
        assertNotNull(attachment.getAttachable());
    }
}