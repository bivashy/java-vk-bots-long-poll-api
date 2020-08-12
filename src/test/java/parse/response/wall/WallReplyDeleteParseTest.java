package parse.response.wall;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
import bots.longpoll.sdk.model.wall.reply.WallReplyDeleteUpdate;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WallReplyDeleteParseTest extends AbstractParseTest {
	@Test
	public void test1_wallReplyDelete() throws IOException {
		JsonObject jsonObject = readJson("json/response/wall_reply_delete/wall_reply_delete_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2633), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertFalse(updates.isEmpty());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("wall_reply_delete", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("c9acacdf064098f14c65b698290b4b103a4b9525", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertTrue(updateObject instanceof WallReplyDeleteUpdate);

		WallReplyDeleteUpdate wallReplyDeleteUpdate = (WallReplyDeleteUpdate) updateObject;
		Assert.assertEquals(Integer.valueOf(-168975658), wallReplyDeleteUpdate.getOwnerId());
		Assert.assertEquals(Integer.valueOf(4), wallReplyDeleteUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), wallReplyDeleteUpdate.getDeleterId());
		Assert.assertEquals(Integer.valueOf(3), wallReplyDeleteUpdate.getPostId());
	}
}
