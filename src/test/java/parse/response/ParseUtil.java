package parse.response;

import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.messages.MessageNewEvent;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParseUtil {
    private static final Gson GSON = new Gson();

    public static JsonElement readJson(String relativePath) {
        try (Reader reader = new FileReader("src/test/resource/".concat(relativePath))) {
            return GSON.fromJson(reader, JsonElement.class);
        } catch (IOException e) {
            fail(e);
        }
        return null;
    }

    private static <T> T notNull(T object) {
        assertNotNull(object);
        return object;
    }

    private static <T> T getFirst(List<T> objects) {
        assertFalse(objects.isEmpty());
        return notNull(objects.get(0));
    }

    public static GetEventsResult getEventsResult(String relativePath) {
        return notNull(GSON.fromJson(readJson(relativePath), GetEventsResult.class));
    }

    public static List<Event> getEvents(String relativePath) {
        return notNull(getEventsResult(relativePath).getEvents());
    }

    public static Event getFirstEvent(String relativePath) {
        return getFirst(getEvents(relativePath));
    }

    public static EventObject getFirstEventObject(String relativePath) {
        return notNull(getFirstEvent(relativePath).getObject());
    }

    public static MessageNewEvent getFirstMessageNewEvent(String relativePath) {
        EventObject eventObject = getFirstEventObject(relativePath);
        assertTrue(eventObject instanceof MessageNewEvent);
        return (MessageNewEvent) eventObject;
    }

    public static Message getFirstMessage(String relativePath) {
        return notNull(getFirstMessageNewEvent(relativePath).getMessage());
    }

    public static List<Attachment> getFirstMessageAttachments(String relativePath) {
        return notNull(getFirstMessage(relativePath).getAttachments());
    }

    public static Attachment getFirstMessageAttachment(String relativePath) {
        return getFirst(getFirstMessageAttachments(relativePath));
    }
}
