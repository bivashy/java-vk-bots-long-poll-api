package parse.response.message;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.objects.basic.Message;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class MessageReplyParseTest {
    @Test
    void messageEdit() {
        Update event = ParseUtil.getFirstEvent("json/response/message_reply/message_reply_sample_5_110.json");
        assertEquals(Update.Type.MESSAGE_REPLY, event.getType());
        assertEquals(555, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof Message);

        Message message = (Message) object;
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
