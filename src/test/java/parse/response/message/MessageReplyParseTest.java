package parse.response.message;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.objects.basic.Message;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class MessageReplyParseTest {
    @Test
    void messageEdit() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/message_reply/message_reply_sample_5_110.json");
        assertEquals(EventType.MESSAGE_REPLY, event.getType());
        assertEquals(555, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof Message);

        Message message = (Message) eventObject;
        assertEquals(1594282112, message.getDate());
        assertEquals(111, message.getFromId());
        assertEquals(222, message.getId());
        assertEquals(333, message.getPeerId());
        assertEquals("test", message.getText());
        assertEquals(261, message.getConversationMessageId());
        assertFalse(message.getImportant());
        assertEquals(0, message.getRandomId());
    }
}
