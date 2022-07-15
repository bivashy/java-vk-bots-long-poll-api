package parse.response.likes;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.likes.Like;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LikeRemoveParseTest {
    @Test
    void likeRemove() {
        List<Update> events = ParseUtil.getEvents("json/response/like_remove/like_remove_sample_5_110.json");
        assertEquals(1, events.size());

        Update event = events.get(0);
        assertNotNull(event);
        assertEquals(Update.Type.LIKE_REMOVE, event.getType());
        assertEquals(333, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);

        assertTrue(object instanceof Like);
        Like audio = (Like) object;
        assertEquals(111, audio.getLikerId());
        assertEquals("post", audio.getObjectType());
        assertEquals(-222, audio.getObjectOwnerId());
        assertEquals(3, audio.getObjectId());
        assertEquals(0, audio.getThreadReplyId());
        assertEquals(0, audio.getPostId());
    }
}
