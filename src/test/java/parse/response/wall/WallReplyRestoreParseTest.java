package parse.response.wall;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
import bots.longpoll.sdk.model.wall.reply.Thread;
import bots.longpoll.sdk.model.wall.reply.WallReplyUpdate;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WallReplyRestoreParseTest extends AbstractParseTest {
	@Test
	public void test1_wallReplyRestore() throws IOException {
		JsonObject jsonObject = readJson("json/response/wall_reply_restore/wall_reply_restore_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2634), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertFalse(updates.isEmpty());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("wall_reply_restore", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("e4266105ccd8fada43069cb23b7a96af453f4274", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertTrue(updateObject instanceof WallReplyUpdate);

		WallReplyUpdate wallReplyUpdate = (WallReplyUpdate) updateObject;
		Assert.assertEquals(Integer.valueOf(4), wallReplyUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), wallReplyUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(3), wallReplyUpdate.getPostId());
		Assert.assertEquals(Integer.valueOf(-168975658), wallReplyUpdate.getOwnerId());
		Assert.assertEquals(Integer.valueOf(1594972082), wallReplyUpdate.getDate());
		Assert.assertEquals(Integer.valueOf(-168975658), wallReplyUpdate.getPostOwnerId());
		Assert.assertEquals("test1", wallReplyUpdate.getText());

		Thread thread = wallReplyUpdate.getThread();
		Assert.assertNotNull(thread);
		Assert.assertEquals(Integer.valueOf(0), thread.getCount());
	}
}
