package parse.response.photo;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.photos.PhotoComment;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoCommentNewParseTest {
    @Test
    void messageEdit() {
        Update event = ParseUtil.getFirstEvent("json/response/photo_comment_new/photo_comment_new_sample_5_110.json");
        assertEquals(Update.Type.PHOTO_COMMENT_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof PhotoComment);

        PhotoComment photoCommentUpdate = (PhotoComment) object;
        assertEquals(3, photoCommentUpdate.getId());
        assertEquals(111, photoCommentUpdate.getFromId());
        assertEquals(1594285508, photoCommentUpdate.getDate());
        assertEquals("t", photoCommentUpdate.getText());
        assertEquals(-222, photoCommentUpdate.getPhotoOwnerId());
        assertEquals(333, photoCommentUpdate.getPhotoId());

        WallComment.Thread thread = photoCommentUpdate.getThread();
        assertNotNull(thread);
        assertEquals(0, thread.getCount());
    }
}
