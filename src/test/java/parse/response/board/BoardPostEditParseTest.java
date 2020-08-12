package parse.response.board;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.board.BoardPostEvent;
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
public class BoardPostEditParseTest extends AbstractParseTest {
	@Test
	public void test1_boardReplyNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/board_post_edit/board_post_edit_sample_5_110.json");
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2636), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("board_post_edit", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("de3b67a449a7afad040c7465c6b8bf9f9615c8f2", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof BoardPostEvent);
		BoardPostEvent boardPostUpdate = (BoardPostEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(2), boardPostUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), boardPostUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(1595841380), boardPostUpdate.getDate());
		Assert.assertEquals("testtest", boardPostUpdate.getText());
		Assert.assertEquals(Integer.valueOf(-168975658), boardPostUpdate.getTopicOwnerId());
		Assert.assertEquals(Integer.valueOf(41499874), boardPostUpdate.getTopicId());
	}
}
