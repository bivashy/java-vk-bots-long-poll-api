package parse.response.board;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.boards.BoardPostEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class BoardPostEditParseTest {
    @Test
    void boardReplyNew() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/board_post_edit/board_post_edit_sample_5_110.json");
        assertEquals(EventType.BOARD_POST_EDIT, event.getType());
        assertEquals(333, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);

        assertTrue(eventObject instanceof BoardPostEvent);
        BoardPostEvent boardPostUpdate = (BoardPostEvent) eventObject;
        assertEquals(2, boardPostUpdate.getId());
        assertEquals(123, boardPostUpdate.getFromId());
        assertEquals(1595841380, boardPostUpdate.getDate());
        assertEquals("testtest", boardPostUpdate.getText());
        assertEquals(-111, boardPostUpdate.getTopicOwnerId());
        assertEquals(222, boardPostUpdate.getTopicId());
    }
}
