package parse.response.wall;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.wall.comments.WallReply;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class WallCommentEditParseTest {
    @Test
    void wallReplyEdit() {
        Update event = ParseUtil.getFirstEvent("json/response/wall_reply_edit/wall_reply_edit_sample_5_110.json");
        assertEquals(Update.Type.WALL_REPLY_EDIT, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof WallReply);

        WallReply wallReplyUpdate = (WallReply) object;
        assertEquals(4, wallReplyUpdate.getId());
        assertEquals(111, wallReplyUpdate.getFromId());
        assertEquals(3, wallReplyUpdate.getPostId());
        assertEquals(-222, wallReplyUpdate.getOwnerId());
        assertEquals(1594972082, wallReplyUpdate.getDate());
        assertEquals(-333, wallReplyUpdate.getPostOwnerId());
        assertEquals("test1", wallReplyUpdate.getText());

        WallComment.Thread thread = wallReplyUpdate.getThread();
        assertNotNull(thread);
        assertEquals(0, thread.getCount());
    }
}
