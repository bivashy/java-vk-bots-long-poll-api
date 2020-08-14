package parse.response.likes;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.likes.LikeEvent;
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
public class LikeRemoveParseTest extends AbstractParseTest {
	@Test
	public void test1_likeRemove() throws IOException {
		JsonObject jsonObject = readJson("json/response/like_remove/like_remove_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2630), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("like_remove", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("f088a0a054f17f1996ca4e7742ffe83e7dd71d5e", event.getEventId());

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
