package parse.response.photo;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.photos.PhotoCommentDeleteEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoCommentDeleteParseTest {
    @Test
    void messageEdit() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/photo_comment_delete/photo_comment_delete_sample_5_110.json");
        assertEquals(EventType.PHOTO_COMMENT_DELETE, event.getType());
        assertEquals(666, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof PhotoCommentDeleteEvent);

        PhotoCommentDeleteEvent photoCommentDeleteUpdate = (PhotoCommentDeleteEvent) eventObject;
        assertEquals(-111, photoCommentDeleteUpdate.getOwnerId());
        assertEquals(333, photoCommentDeleteUpdate.getId());
        assertEquals(222, photoCommentDeleteUpdate.getDeleterId());
        assertEquals(444, photoCommentDeleteUpdate.getPhotoId());
        assertEquals(555, photoCommentDeleteUpdate.getUserId());
    }
}
