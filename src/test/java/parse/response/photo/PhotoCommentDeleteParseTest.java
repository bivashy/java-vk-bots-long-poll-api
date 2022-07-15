package parse.response.photo;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.photos.PhotoCommentDelete;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoCommentDeleteParseTest {
    @Test
    void messageEdit() {
        Update event = ParseUtil.getFirstEvent("json/response/photo_comment_delete/photo_comment_delete_sample_5_110.json");
        assertEquals(Update.Type.PHOTO_COMMENT_DELETE, event.getType());
        assertEquals(666, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof PhotoCommentDelete);

        PhotoCommentDelete photoCommentDeleteUpdate = (PhotoCommentDelete) object;
        assertEquals(-111, photoCommentDeleteUpdate.getOwnerId());
        assertEquals(333, photoCommentDeleteUpdate.getId());
        assertEquals(222, photoCommentDeleteUpdate.getDeleterId());
        assertEquals(444, photoCommentDeleteUpdate.getPhotoId());
        assertEquals(555, photoCommentDeleteUpdate.getUserId());
    }
}
