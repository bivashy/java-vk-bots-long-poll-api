package parse.response.board;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.boards.BoardPostDelete;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class BoardPostDeleteParseTest {
    @Test
    void boardReplyNew() {
        Update event = ParseUtil.getFirstEvent("json/response/board_post_delete/board_post_delete_sample_5_110.json");
        assertEquals(Update.Type.BOARD_POST_DELETE, event.getType());
        assertEquals(123, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);

        assertTrue(object instanceof BoardPostDelete);
        BoardPostDelete boardPostDeleteUpdate = (BoardPostDelete) object;
        assertEquals(-111, boardPostDeleteUpdate.getTopicOwnerId());
        assertEquals(3, boardPostDeleteUpdate.getId());
        assertEquals(333, boardPostDeleteUpdate.getTopicId());
    }
}
