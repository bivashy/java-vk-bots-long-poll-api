package parse.response.board;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.boards.BoardPostEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class BoardReplyNewParseTest {
    @Test
    void boardReplyNew() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/board_post_new/board_post_new_sample_5_110.json");
        assertEquals(EventType.BOARD_POST_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);

        assertTrue(eventObject instanceof BoardPostEvent);
        BoardPostEvent boardPostUpdate = (BoardPostEvent) eventObject;
        assertEquals(2, boardPostUpdate.getId());
        assertEquals(111, boardPostUpdate.getFromId());
        assertEquals(1595841380, boardPostUpdate.getDate());
        assertEquals("test", boardPostUpdate.getText());
        assertEquals(-222, boardPostUpdate.getTopicOwnerId());
        assertEquals(333, boardPostUpdate.getTopicId());
    }
}
