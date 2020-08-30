package parse.response.other;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.other.GroupChangeSettingsEvent;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupChangeSettingsParseTest extends AbstractParseTest {
	@Test
	public void test1_likeAdd() throws IOException {
		JsonObject jsonObject = readJson("json/response/group_change_settings/group_change_settings_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2644), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("group_change_settings", event.getType());
		Assert.assertEquals(Integer.valueOf(222), event.getGroupId());
		Assert.assertEquals("aaa", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof GroupChangeSettingsEvent);
		GroupChangeSettingsEvent groupChangeSettingsUpdate = (GroupChangeSettingsEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(111), groupChangeSettingsUpdate.getUserId());

		Map<String, GroupChangeSettingsEvent.Change> changes = groupChangeSettingsUpdate.getChanges();
		Assert.assertNotNull(changes);
		Assert.assertFalse(changes.isEmpty());
		Assert.assertTrue(changes.containsKey("description"));

		GroupChangeSettingsEvent.Change change = changes.get("description");
		Assert.assertNotNull(change);
		Assert.assertEquals("test", change.getOldValue());
		Assert.assertEquals("test1", change.getNewValue());
	}
}
