package parse.response.message;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.messages.MessageTypingState;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTypingStateParseTest {
    @Test
    void messageTypingState() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/message_typing_state/message_typing_state_sample_5_111.json");
        assertEquals(EventType.MESSAGE_TYPING_STATE, event.getType());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof MessageTypingState);

        MessageTypingState messageTypingState = (MessageTypingState) eventObject;
        assertEquals("typing", messageTypingState.getState());
        assertEquals(789, messageTypingState.getFromId());
        assertEquals(-456, messageTypingState.getToId());
    }
}
