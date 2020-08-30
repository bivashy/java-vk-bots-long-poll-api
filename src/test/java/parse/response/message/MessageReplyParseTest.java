package parse.response.message;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.objects.basic.Message;
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
public class MessageReplyParseTest extends AbstractParseTest {
	@Test
	public void test1_messageEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_reply/message_reply_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2610), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("message_reply", event.getType());
		Assert.assertEquals(Integer.valueOf(555), event.getGroupId());
		Assert.assertEquals("aaa", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof Message);
		Message message = (Message) eventObject;
		Assert.assertNotNull(message);
		Assert.assertEquals(Integer.valueOf(1594282112), message.getDate());
		Assert.assertEquals(Integer.valueOf(111), message.getFromId());
		Assert.assertEquals(Integer.valueOf(222), message.getId());
		Assert.assertEquals(Integer.valueOf(333), message.getPeerId());
		Assert.assertEquals("test", message.getText());
		Assert.assertEquals(Integer.valueOf(261), message.getConversationMessageId());
		Assert.assertFalse(message.getImportant());
		Assert.assertEquals(Integer.valueOf(0), message.getRandomId());
	}
}
