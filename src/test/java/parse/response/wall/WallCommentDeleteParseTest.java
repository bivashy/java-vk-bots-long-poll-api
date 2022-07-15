package parse.response.wall;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.wall.comments.WallReplyDelete;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class WallCommentDeleteParseTest {
    @Test
    void wallReplyDelete() {
        Update event = ParseUtil.getFirstEvent("json/response/wall_reply_delete/wall_reply_delete_sample_5_110.json");
        assertEquals(Update.Type.WALL_REPLY_DELETE, event.getType());
        assertEquals(333, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof WallReplyDelete);

        WallReplyDelete wallReplyDeleteUpdate = (WallReplyDelete) object;
        assertEquals(-111, wallReplyDeleteUpdate.getOwnerId());
        assertEquals(4, wallReplyDeleteUpdate.getId());
        assertEquals(222, wallReplyDeleteUpdate.getDeleterId());
        assertEquals(3, wallReplyDeleteUpdate.getPostId());
    }
}
