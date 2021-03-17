package parse.response.other;

import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.other.GroupChangeSettingsEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseTestUtil;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GroupChangeSettingsParseTest {
    @Test
    void likeAdd() {
        Event event = ParseTestUtil.getFirstEvent("json/response/group_change_settings/group_change_settings_sample_5_110.json");
        assertEquals(EventType.GROUP_CHANGE_SETTINGS, event.getType());
        assertEquals(222, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof GroupChangeSettingsEvent);

        GroupChangeSettingsEvent groupChangeSettingsUpdate = (GroupChangeSettingsEvent) eventObject;
        assertEquals(111, groupChangeSettingsUpdate.getUserId());

        Map<String, GroupChangeSettingsEvent.Change> changes = groupChangeSettingsUpdate.getChanges();
        assertNotNull(changes);
        assertFalse(changes.isEmpty());
        assertTrue(changes.containsKey("description"));

        GroupChangeSettingsEvent.Change change = changes.get("description");
        assertNotNull(change);
        assertEquals("test", change.getOldValue());
        assertEquals("test1", change.getNewValue());
    }
}
