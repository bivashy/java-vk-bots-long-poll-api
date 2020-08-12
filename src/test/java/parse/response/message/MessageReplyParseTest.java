package parse.response.message;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.messages.Message;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
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
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2610), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("message_reply", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("eaf895294b6f1cdaf944f1fb5f1651d0ba0469de", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof Message);
		Message message = (Message) updateObject;
		Assert.assertNotNull(message);
		Assert.assertEquals(Integer.valueOf(1594282112), message.getDate());
		Assert.assertEquals(Integer.valueOf(381980625), message.getFromId());
		Assert.assertEquals(Integer.valueOf(276), message.getId());
		Assert.assertEquals(Integer.valueOf(381980625), message.getPeerId());
		Assert.assertEquals("test", message.getText());
		Assert.assertEquals(Integer.valueOf(261), message.getConversationMessageId());
		Assert.assertFalse(message.isImportant());
		Assert.assertEquals(Integer.valueOf(0), message.getRandomId());
		Assert.assertFalse(message.isHidden());
	}
}
