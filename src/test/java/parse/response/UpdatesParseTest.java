package parse.response;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.response.events.GetUpdatesResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UpdatesParseTest {
    @Test
    void emptyUpdatesParse() {
        GetUpdatesResult getEventsResult = ParseUtil.getEventsResult("json/response/empty_updates_sample_5_110.json");
        assertEquals(2587, getEventsResult.getTs());

        List<VkEvent> events = getEventsResult.getEvents();
        assertNotNull(events);
        assertTrue(events.isEmpty());
    }

    @Test
    void updatesFailed() {
        GetUpdatesResult getEventsResult = ParseUtil.getEventsResult("json/response/get_updates_failed_1_5_110.json");
        assertEquals(2593, getEventsResult.getTs());
    }
}
