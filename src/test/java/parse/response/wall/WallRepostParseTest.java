package parse.response.wall;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
import bots.longpoll.sdk.model.wall.post.Comments;
import bots.longpoll.sdk.model.wall.post.PostSource;
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
public class WallRepostParseTest extends AbstractParseTest {
	@Test
	public void test1_wallRepost() throws IOException {
		JsonObject jsonObject = readJson("json/response/wall_repost/wall_repost_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2628), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("wall_repost", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("c8d1bb13eeb3da344a09fe901d112fc80a2abf30", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof WallPost);
		WallPost wallPost = (WallPost) updateObject;
		Assert.assertEquals(Integer.valueOf(34), wallPost.getId());
		Assert.assertEquals(Integer.valueOf(381980625), wallPost.getFromId());
		Assert.assertEquals(Integer.valueOf(381980625), wallPost.getOwnerId());
		Assert.assertEquals(Integer.valueOf(1594890511), wallPost.getDate());
		Assert.assertEquals("post", wallPost.getPostType());
		Assert.assertEquals("", wallPost.getText());
		Assert.assertTrue(wallPost.isCanArchive());
		Assert.assertFalse(wallPost.isArchived());
		Assert.assertFalse(wallPost.isFavourite());

		Comments comments = wallPost.getComments();
		Assert.assertNotNull(comments);
		Assert.assertEquals(Integer.valueOf(0), comments.getCount());

		List<WallPost> copyHistory = wallPost.getCopyHistory();
		Assert.assertNotNull(copyHistory);
		Assert.assertEquals(1, copyHistory.size());

		WallPost post = copyHistory.get(0);
		Assert.assertNotNull(post);
		Assert.assertEquals(Integer.valueOf(3), post.getId());
		Assert.assertEquals(Integer.valueOf(-168975658), post.getOwnerId());
		Assert.assertEquals(Integer.valueOf(-168975658), post.getFromId());
		Assert.assertEquals(Integer.valueOf(1594890485), post.getDate());
		Assert.assertEquals("post", post.getPostType());
		Assert.assertEquals("test", post.getText());

		PostSource postSource = post.getPostSource();
		Assert.assertNotNull(postSource);
		Assert.assertEquals("vk", postSource.getType());
	}
}
