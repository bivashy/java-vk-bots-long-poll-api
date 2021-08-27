package parse.response.likes;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.likes.LikeEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class LikeAddParseTest {
    @Test
    void likeAdd() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/like_add/like_add_sample_5_110.json");
        assertEquals(EventType.LIKE_ADD, event.getType());
        assertEquals(333, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);

        assertTrue(eventObject instanceof LikeEvent);
        LikeEvent audio = (LikeEvent) eventObject;
        assertEquals(111, audio.getLikerId());
        assertEquals("post", audio.getObjectType());
        assertEquals(-222, audio.getObjectOwnerId());
        assertEquals(3, audio.getObjectId());
        assertEquals(0, audio.getThreadReplyId());
        assertEquals(0, audio.getPostId());
    }
}
