package parse.response.wall;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
import bots.longpoll.sdk.model.wall.post.Comments;
import bots.longpoll.sdk.model.wall.post.WallPost;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WallPostNewParseTest extends AbstractParseTest {
	@Test
	public void test1_wallPostNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/wall_post_new/wall_post_new_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2626), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("wall_post_new", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("a7908558beb83a61332f329e93ffea33598e361c", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof WallPost);
		WallPost wallPost = (WallPost) updateObject;
		Assert.assertEquals(Integer.valueOf(1), wallPost.getId());
		Assert.assertEquals(Integer.valueOf(381980625), wallPost.getFromId());
		Assert.assertEquals(Integer.valueOf(-168975658), wallPost.getOwnerId());
		Assert.assertEquals(Integer.valueOf(1594888935), wallPost.getDate());
		Assert.assertFalse(wallPost.isMarkedAsAds());
		Assert.assertEquals("post", wallPost.getPostType());
		Assert.assertEquals("test", wallPost.getText());
		Assert.assertTrue(wallPost.isCanEdit());
		Assert.assertEquals(Integer.valueOf(381980625), wallPost.getCreatedBy());
		Assert.assertTrue(wallPost.isCanDelete());
		Assert.assertFalse(wallPost.isFavourite());

		Comments comments = wallPost.getComments();
		Assert.assertNotNull(comments);
		Assert.assertEquals(Integer.valueOf(0), comments.getCount());
	}
}
