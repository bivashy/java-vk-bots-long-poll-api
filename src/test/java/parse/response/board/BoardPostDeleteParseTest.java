package parse.response.board;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.boards.BoardPostDeleteEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class BoardPostDeleteParseTest {
    @Test
    void boardReplyNew() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/board_post_delete/board_post_delete_sample_5_110.json");
        assertEquals(EventType.BOARD_POST_DELETE, event.getType());
        assertEquals(123, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);

        assertTrue(eventObject instanceof BoardPostDeleteEvent);
        BoardPostDeleteEvent boardPostDeleteUpdate = (BoardPostDeleteEvent) eventObject;
        assertEquals(-111, boardPostDeleteUpdate.getTopicOwnerId());
        assertEquals(3, boardPostDeleteUpdate.getId());
        assertEquals(333, boardPostDeleteUpdate.getTopicId());
    }
}
