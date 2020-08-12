package parse.response.wall;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.wall.post.Comments;
import api.longpoll.bots.model.wall.post.WallPost;
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
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2626), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("wall_post_new", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("a7908558beb83a61332f329e93ffea33598e361c", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof WallPost);
		WallPost wallPost = (WallPost) eventObject;
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
