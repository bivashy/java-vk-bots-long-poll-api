package parse.response.message;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.messages.MessageTypingState;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTypingStateParseTest {
    @Test
    void messageTypingState() {
        Update event = ParseUtil.getFirstEvent("json/response/message_typing_state/message_typing_state_sample_5_111.json");
        assertEquals(Update.Type.MESSAGE_TYPING_STATE, event.getType());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof MessageTypingState);

        MessageTypingState messageTypingState = (MessageTypingState) object;
        assertEquals("typing", messageTypingState.getState());
        assertEquals(789, messageTypingState.getFromId());
        assertEquals(-456, messageTypingState.getToId());
    }
}
