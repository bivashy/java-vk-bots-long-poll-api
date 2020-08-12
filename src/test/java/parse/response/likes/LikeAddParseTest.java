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
public class LikeAddParseTest extends AbstractParseTest {
	@Test
	public void test1_likeAdd() throws IOException {
		JsonObject jsonObject = readJson("json/response/like_add/like_add_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2629), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("like_add", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("3118e7a0997ee58f62536cca69f2cff7bdbe9fd0", update.getEventId());

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
