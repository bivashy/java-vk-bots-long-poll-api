package parse.response.message;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.objects.basic.Message;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class MessageEditParseTest {
    @Test
    void messageEdit() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/message_edit/message_edit_sample_5_110.json");
        assertEquals(EventType.MESSAGE_EDIT, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);

        assertTrue(eventObject instanceof Message);
        Message message = (Message) eventObject;
        assertNotNull(message);
        assertEquals(1594282377, message.getDate());
        assertEquals(-111, message.getFromId());
        assertEquals(276, message.getId());
        assertEquals(222, message.getPeerId());
        assertEquals("tests", message.getText());
        assertEquals(261, message.getConversationMessageId());
        assertFalse(message.getImportant());
        assertEquals(0, message.getRandomId());
    }
}
