package parse.response.photo;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.photos.PhotoCommentEvent;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoCommentEditParseTest {
    @Test
    void messageEdit() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/photo_comment_edit/photo_comment_edit_sample_5_110.json");
        assertEquals(EventType.PHOTO_COMMENT_EDIT, event.getType());
        assertEquals(555, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof PhotoCommentEvent);

        PhotoCommentEvent photoCommentUpdate = (PhotoCommentEvent) eventObject;
        assertEquals(111, photoCommentUpdate.getId());
        assertEquals(222, photoCommentUpdate.getFromId());
        assertEquals(1594285508, photoCommentUpdate.getDate());
        assertEquals("tt", photoCommentUpdate.getText());
        assertEquals(-333, photoCommentUpdate.getPhotoOwnerId());
        assertEquals(444, photoCommentUpdate.getPhotoId());

        WallComment.Thread thread = photoCommentUpdate.getThread();
        assertNotNull(thread);
        assertEquals(0, thread.getCount());
    }
}
