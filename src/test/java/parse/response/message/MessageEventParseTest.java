package parse.response.message;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.messages.MessageEvent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageEventParseTest {
    @Test
    void messageEventPayload() {
        EventObject eventObject = ParseUtil.getFirstEventObject("json/response/message_event/message_event_payload_sample_5_118.json");
        assertTrue(eventObject instanceof MessageEvent);

        MessageEvent messageEvent = (MessageEvent) eventObject;
        JsonElement element = messageEvent.getPayload();
        assertNotNull(element);
        assertTrue(element.isJsonObject());

        JsonObject payload = element.getAsJsonObject();
        //assertEquals("{\"data\":\"clicked\",\"time\":1622383763657,\"values\":[11,22,33],\"status\":{\"active\":true}}", payload);
        assertTrue(payload.has("data"));
        assertEquals("clicked", payload.get("data").getAsString());
        assertTrue(payload.has("time"));
        assertEquals(1622386091581L, payload.get("time").getAsLong());

        assertTrue(payload.has("values"));
        JsonArray jsonArray = payload.getAsJsonArray("values");
        assertEquals(3, jsonArray.size());
        assertEquals(11, jsonArray.get(0).getAsInt());
        assertEquals(22, jsonArray.get(1).getAsInt());
        assertEquals(33, jsonArray.get(2).getAsInt());

        assertTrue(payload.has("status"));
        JsonObject jsonObject = payload.getAsJsonObject("status");
        assertTrue(jsonObject.has("active"));
        assertTrue(jsonObject.get("active").getAsBoolean());
    }
}
