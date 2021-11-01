package api.longpoll.bots.converters.response.messages;

import api.longpoll.bots.methods.impl.messages.GetHistory;
import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.media.AttachmentType;
import api.longpoll.bots.model.objects.media.Photo;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessagesGetHistoryResultConverterTest {
    private static final Gson GSON = new Gson();

    @Test
    void convert() {
        GetHistory.Response result = GSON.fromJson(ParseUtil.readJson("json/response/messages_get_history/messages_get_history_sample_5_118.json"), GetHistory.Response.class);
        assertNotNull(result);

        GetHistory.Response.ResponseObject response = result.getResponseObject();
        assertNotNull(response);
        assertEquals(241, response.getCount());

        List<Message> items = response.getItems();
        assertNotNull(items);
        assertFalse(items.isEmpty());

        Message message = items.get(0);
        assertNotNull(message);
        assertEquals(1616867831, message.getDate());
        assertEquals(423, message.getFromId());
        assertEquals(619, message.getId());
        assertEquals(543, message.getPeerId());
        assertEquals(595, message.getConversationMessageId());
        assertTrue(message.hasAttachments());

        Attachment attachment = message.getAttachments().get(0);
        assertNotNull(attachment);
        assertEquals(AttachmentType.PHOTO, attachment.getType());

        Photo photo = (Photo) attachment.getAttachable();
        assertNotNull(photo);
        assertEquals(-3, photo.getAlbumId());
        assertEquals(1616867830, photo.getDate());
        assertEquals(654, photo.getId());
        assertEquals(14325, photo.getOwnerId());

        List<PhotoSize> photoSizes = photo.getPhotoSizes();
        assertNotNull(photoSizes);
        assertFalse(photoSizes.isEmpty());
    }
}