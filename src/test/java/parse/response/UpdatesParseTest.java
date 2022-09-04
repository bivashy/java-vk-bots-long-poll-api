package parse.response;

import api.longpoll.bots.methods.impl.events.GetUpdates;
import api.longpoll.bots.model.events.Update;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdatesParseTest {
    @Test
    void emptyUpdatesParse() {
        GetUpdates.ResponseBody responseBody = ParseUtil.getEventsResult("json/response/empty_updates_sample_5_110.json");
        assertEquals(2587, responseBody.getTs());

        List<Update> events = responseBody.getEvents();
        assertNotNull(events);
        assertTrue(events.isEmpty());
    }

    @Test
    void updatesFailed() {
        GetUpdates.ResponseBody responseBody = ParseUtil.getEventsResult("json/response/get_updates_failed_1_5_110.json");
        assertEquals(2593, responseBody.getTs());
    }
}
