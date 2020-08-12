package parse.response.message;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.objects.basic.Message;
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
public class MessageEditParseTest extends AbstractParseTest {
	@Test
	public void test1_messageEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_edit/message_edit_sample_5_110.json");
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2611), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("message_edit", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("6517aa2171da46748a39a44166a7c775777b9f25", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof Message);
		Message message = (Message) eventObject;
		Assert.assertNotNull(message);
		Assert.assertEquals(Integer.valueOf(1594282377), message.getDate());
		Assert.assertEquals(Integer.valueOf(-168975658), message.getFromId());
		Assert.assertEquals(Integer.valueOf(276), message.getId());
		Assert.assertEquals(Integer.valueOf(381980625), message.getPeerId());
		Assert.assertEquals("tests", message.getText());
		Assert.assertEquals(Integer.valueOf(261), message.getConversationMessageId());
		Assert.assertFalse(message.isImportant());
		Assert.assertEquals(Integer.valueOf(0), message.getRandomId());
		Assert.assertFalse(message.isHidden());
	}
}
