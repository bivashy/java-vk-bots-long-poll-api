package parse.response.board;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.boards.BoardPost;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class BoardReplyNewParseTest {
    @Test
    void boardReplyNew() {
        Update event = ParseUtil.getFirstEvent("json/response/board_post_new/board_post_new_sample_5_110.json");
        assertEquals(Update.Type.BOARD_POST_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);

        assertTrue(object instanceof BoardPost);
        BoardPost boardPostUpdate = (BoardPost) object;
        assertEquals(2, boardPostUpdate.getId());
        assertEquals(111, boardPostUpdate.getFromId());
        assertEquals(1595841380, boardPostUpdate.getDate());
        assertEquals("test", boardPostUpdate.getText());
        assertEquals(-222, boardPostUpdate.getTopicOwnerId());
        assertEquals(333, boardPostUpdate.getTopicId());
    }
}
