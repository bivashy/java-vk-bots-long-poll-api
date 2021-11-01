package parse.response.wall;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.wall.comments.WallReplyDeleteEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class WallCommentDeleteParseTest {
    @Test
    void wallReplyDelete() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/wall_reply_delete/wall_reply_delete_sample_5_110.json");
        assertEquals(EventType.WALL_REPLY_DELETE, event.getType());
        assertEquals(333, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof WallReplyDeleteEvent);

        WallReplyDeleteEvent wallReplyDeleteUpdate = (WallReplyDeleteEvent) eventObject;
        assertEquals(-111, wallReplyDeleteUpdate.getOwnerId());
        assertEquals(4, wallReplyDeleteUpdate.getId());
        assertEquals(222, wallReplyDeleteUpdate.getDeleterId());
        assertEquals(3, wallReplyDeleteUpdate.getPostId());
    }
}
