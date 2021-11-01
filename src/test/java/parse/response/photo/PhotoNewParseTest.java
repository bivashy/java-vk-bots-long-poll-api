package parse.response.photo;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.objects.media.Photo;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoNewParseTest {
    @Test
    void messageEdit() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/photo_new/photo_new_sample_5_110.json");
        assertEquals(EventType.PHOTO_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof Photo);

        Photo photo = (Photo) eventObject;
        assertEquals(111, photo.getAlbumId());
        assertEquals(1594284077, photo.getDate());
        assertEquals(222, photo.getId());
        assertEquals(-333, photo.getOwnerId());
        assertFalse(photo.hasText());
        assertEquals(555, photo.getUserId());

        List<PhotoSize> photoSizes = photo.getPhotoSizes();
        assertNotNull(photo);
        assertFalse(photoSizes.isEmpty());
    }
}
