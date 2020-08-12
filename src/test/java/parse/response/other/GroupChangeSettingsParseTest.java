package parse.response.other;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.other.Change;
import bots.longpoll.sdk.model.other.GroupChangeSettingsUpdate;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
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
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2644), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("group_change_settings", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("e2a922b60f3002aa5e5098084c971107ec85e61a", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof GroupChangeSettingsUpdate);
		GroupChangeSettingsUpdate groupChangeSettingsUpdate = (GroupChangeSettingsUpdate) updateObject;
		Assert.assertEquals(Integer.valueOf(381980625), groupChangeSettingsUpdate.getUserId());

		Map<String, Change> changes = groupChangeSettingsUpdate.getChanges();
		Assert.assertNotNull(changes);
		Assert.assertFalse(changes.isEmpty());
		Assert.assertTrue(changes.containsKey("description"));

		Change change = changes.get("description");
		Assert.assertNotNull(change);
		Assert.assertEquals("test", change.getOldValue());
		Assert.assertEquals("test1", change.getNewValue());
	}
}
