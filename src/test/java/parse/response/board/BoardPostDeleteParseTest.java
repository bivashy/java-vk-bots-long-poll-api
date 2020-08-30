package parse.response.board;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.boards.BoardPostDeleteEvent;
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
public class BoardPostDeleteParseTest extends AbstractParseTest {
	@Test
	public void test1_boardReplyNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/board_post_delete/board_post_delete_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2638), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("board_post_delete", event.getType());
		Assert.assertEquals(Integer.valueOf(123), event.getGroupId());
		Assert.assertEquals("aaa", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof BoardPostDeleteEvent);
		BoardPostDeleteEvent boardPostDeleteUpdate = (BoardPostDeleteEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(-111), boardPostDeleteUpdate.getTopicOwnerId());
		Assert.assertEquals(Integer.valueOf(3), boardPostDeleteUpdate.getId());
		Assert.assertEquals(Integer.valueOf(333), boardPostDeleteUpdate.getTopicId());
	}
}
