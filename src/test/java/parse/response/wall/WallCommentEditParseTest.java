package parse.response.wall;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.wall.reply.Thread;
import api.longpoll.bots.model.wall.reply.WallReplyEvent;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WallCommentEditParseTest extends AbstractParseTest {
	@Test
	public void test1_wallReplyEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/wall_reply_edit/wall_reply_edit_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2632), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertFalse(events.isEmpty());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("wall_reply_edit", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("2723997e68891a0c9a14418a39b89d8a6a685418", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertTrue(eventObject instanceof WallReplyEvent);

		WallReplyEvent wallReplyUpdate = (WallReplyEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(4), wallReplyUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), wallReplyUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(3), wallReplyUpdate.getPostId());
		Assert.assertEquals(Integer.valueOf(-168975658), wallReplyUpdate.getOwnerId());
		Assert.assertEquals(Integer.valueOf(1594972082), wallReplyUpdate.getDate());
		Assert.assertEquals(Integer.valueOf(-168975658), wallReplyUpdate.getPostOwnerId());
		Assert.assertEquals("test1", wallReplyUpdate.getText());

		Thread thread = wallReplyUpdate.getThread();
		Assert.assertNotNull(thread);
		Assert.assertEquals(Integer.valueOf(0), thread.getCount());
	}
}
