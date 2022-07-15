package parse.response.message;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.objects.basic.Message;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class MessageEditParseTest {
    @Test
    void messageEdit() {
        Update event = ParseUtil.getFirstEvent("json/response/message_edit/message_edit_sample_5_110.json");
        assertEquals(Update.Type.MESSAGE_EDIT, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);

        assertTrue(object instanceof Message);
        Message message = (Message) object;
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
