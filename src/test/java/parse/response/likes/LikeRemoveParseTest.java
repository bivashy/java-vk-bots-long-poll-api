package parse.response.likes;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.likes.LikeUpdate;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LikeRemoveParseTest extends AbstractParseTest {
	@Test
	public void test1_likeRemove() throws IOException {
		JsonObject jsonObject = readJson("json/response/like_remove/like_remove_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2630), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("like_remove", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("f088a0a054f17f1996ca4e7742ffe83e7dd71d5e", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof LikeUpdate);
		LikeUpdate audio = (LikeUpdate) updateObject;
		Assert.assertEquals(Integer.valueOf(381980625), audio.getLikerId());
		Assert.assertEquals("post", audio.getObjectType());
		Assert.assertEquals(Integer.valueOf(-168975658), audio.getObjectOwnerId());
		Assert.assertEquals(Integer.valueOf(3), audio.getObjectId());
		Assert.assertEquals(Integer.valueOf(0), audio.getThreadReplyId());
		Assert.assertEquals(Integer.valueOf(0), audio.getPostId());
	}
}
