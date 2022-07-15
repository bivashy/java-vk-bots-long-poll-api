package parse.response.photo;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.objects.media.Photo;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoNewParseTest {
    @Test
    void messageEdit() {
        Update event = ParseUtil.getFirstEvent("json/response/photo_new/photo_new_sample_5_110.json");
        assertEquals(Update.Type.PHOTO_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof Photo);

        Photo photo = (Photo) object;
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
