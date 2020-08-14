package parse.response.likes;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.likes.LikeEvent;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LikeAddParseTest extends AbstractParseTest {
	@Test
	public void test1_likeAdd() throws IOException {
		JsonObject jsonObject = readJson("json/response/like_add/like_add_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2629), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("like_add", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("3118e7a0997ee58f62536cca69f2cff7bdbe9fd0", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof LikeEvent);
		LikeEvent audio = (LikeEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(381980625), audio.getLikerId());
		Assert.assertEquals("post", audio.getObjectType());
		Assert.assertEquals(Integer.valueOf(-168975658), audio.getObjectOwnerId());
		Assert.assertEquals(Integer.valueOf(3), audio.getObjectId());
		Assert.assertEquals(Integer.valueOf(0), audio.getThreadReplyId());
		Assert.assertEquals(Integer.valueOf(0), audio.getPostId());
	}
}
