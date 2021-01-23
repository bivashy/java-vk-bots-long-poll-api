package parse.response.message;

import api.longpoll.bots.converters.response.events.GetEventsResultConverter;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.messages.MessageTypingStateEvent;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessageTypingStateParseTest extends AbstractParseTest {
    @Test
    public void test1_messageTypingState() throws IOException {
        JsonObject jsonObject = readJson("json/response/message_typing_state/message_typing_state_sample_5_111.json");
        GetEventsResult getEventsResult = new GetEventsResultConverter().convert(jsonObject);
        List<Event> events = getEventsResult.getEvents();
        Assert.assertNotNull(events);
        Assert.assertTrue(events.size() > 0);

        Event event = events.get(0);
        Assert.assertNotNull(event);
        Assert.assertEquals(EventType.MESSAGE_TYPING_STATE, event.getType());

        EventObject object = event.getObject();
        Assert.assertNotNull(object);

        MessageTypingStateEvent eventObject = (MessageTypingStateEvent) object;
        Assert.assertEquals("typing", eventObject.getState());
        Assert.assertEquals(Integer.valueOf(789), eventObject.getFromId());
        Assert.assertEquals(Integer.valueOf(-456), eventObject.getToId());
    }
}
