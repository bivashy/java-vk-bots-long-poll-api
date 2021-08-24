package parse.response.likes;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.likes.LikeEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LikeRemoveParseTest {
    @Test
    void likeRemove() {
        List<VkEvent> events = ParseUtil.getEvents("json/response/like_remove/like_remove_sample_5_110.json");
        assertEquals(1, events.size());

        VkEvent event = events.get(0);
        assertNotNull(event);
        assertEquals(EventType.LIKE_REMOVE, event.getType());
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
