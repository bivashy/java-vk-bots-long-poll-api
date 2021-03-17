package parse.response;

import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.response.events.GetEventsResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UpdatesParseTest {
    @Test
    void emptyUpdatesParse() {
        GetEventsResult getEventsResult = ParseTestUtil.getEventsResult("json/response/empty_updates_sample_5_110.json");
        assertEquals(2587, getEventsResult.getTs());

        List<Event> events = getEventsResult.getEvents();
        assertNotNull(events);
        assertTrue(events.isEmpty());
    }

    @Test
    void updatesFailed() {
        GetEventsResult getEventsResult = ParseTestUtil.getEventsResult("json/response/get_updates_failed_1_5_110.json");
        assertEquals(2593, getEventsResult.getTs());
    }
}
