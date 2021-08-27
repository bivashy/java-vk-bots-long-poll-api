package parse.response;

import api.longpoll.bots.methods.impl.events.GetUpdates;
import api.longpoll.bots.model.events.VkEvent;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdatesParseTest {
    @Test
    void emptyUpdatesParse() {
        GetUpdates.Response response = ParseUtil.getEventsResult("json/response/empty_updates_sample_5_110.json");
        assertEquals(2587, response.getTs());

        List<VkEvent> events = response.getEvents();
        assertNotNull(events);
        assertTrue(events.isEmpty());
    }

    @Test
    void updatesFailed() {
        GetUpdates.Response response = ParseUtil.getEventsResult("json/response/get_updates_failed_1_5_110.json");
        assertEquals(2593, response.getTs());
    }
}
