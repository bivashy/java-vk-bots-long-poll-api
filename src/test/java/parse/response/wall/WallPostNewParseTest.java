package parse.response.wall;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.objects.basic.WallPost;
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
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2626), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("wall_post_new", event.getType());
		Assert.assertEquals(Integer.valueOf(444), event.getGroupId());
		Assert.assertEquals("aaa", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof WallPost);
		WallPost wallPost = (WallPost) eventObject;
		Assert.assertEquals(Integer.valueOf(1), wallPost.getId());
		Assert.assertEquals(Integer.valueOf(111), wallPost.getFromId());
		Assert.assertEquals(Integer.valueOf(-222), wallPost.getOwnerId());
		Assert.assertEquals(Integer.valueOf(1594888935), wallPost.getDate());
		Assert.assertFalse(wallPost.getMarkedAsAds());
		Assert.assertEquals("post", wallPost.getPostType());
		Assert.assertEquals("test", wallPost.getText());
		Assert.assertTrue(wallPost.getCanEdit());
		Assert.assertEquals(Integer.valueOf(333), wallPost.getCreatedBy());
		Assert.assertTrue(wallPost.getCanDelete());
		Assert.assertFalse(wallPost.getFavourite());

		WallPost.Comments comments = wallPost.getComments();
		Assert.assertNotNull(comments);
		Assert.assertEquals(Integer.valueOf(0), comments.getCount());
	}
}
