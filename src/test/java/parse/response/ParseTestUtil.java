package parse.response;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.response.events.GetEventsResultConverter;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.messages.MessageNewEvent;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParseTestUtil {
    private static final Gson GSON = new Gson();
    private static final JsonToPojoConverter<GetEventsResult> GET_EVENTS_RESULT_CONVERTER = new GetEventsResultConverter();

    public static JsonObject readJson(String relativePath) {
        try (Reader reader = new FileReader("src/test/resource/".concat(relativePath))) {
            return GSON.fromJson(reader, JsonObject.class);
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
        return notNull(GET_EVENTS_RESULT_CONVERTER.convert(readJson(relativePath)));
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
