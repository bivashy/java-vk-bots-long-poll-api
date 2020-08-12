package parse.response.wall;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.wall.reply.WallReplyDeleteEvent;
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
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2633), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertFalse(events.isEmpty());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("wall_reply_delete", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("c9acacdf064098f14c65b698290b4b103a4b9525", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertTrue(eventObject instanceof WallReplyDeleteEvent);

		WallReplyDeleteEvent wallReplyDeleteUpdate = (WallReplyDeleteEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(-168975658), wallReplyDeleteUpdate.getOwnerId());
		Assert.assertEquals(Integer.valueOf(4), wallReplyDeleteUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), wallReplyDeleteUpdate.getDeleterId());
		Assert.assertEquals(Integer.valueOf(3), wallReplyDeleteUpdate.getPostId());
	}
}
