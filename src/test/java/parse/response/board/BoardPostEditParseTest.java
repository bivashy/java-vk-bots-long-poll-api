package parse.response.board;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.board.BoardPostUpdate;
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
public class BoardPostEditParseTest extends AbstractParseTest {
	@Test
	public void test1_boardReplyNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/board_post_edit/board_post_edit_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2636), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("board_post_edit", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("de3b67a449a7afad040c7465c6b8bf9f9615c8f2", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof BoardPostUpdate);
		BoardPostUpdate boardPostUpdate = (BoardPostUpdate) updateObject;
		Assert.assertEquals(Integer.valueOf(2), boardPostUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), boardPostUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(1595841380), boardPostUpdate.getDate());
		Assert.assertEquals("testtest", boardPostUpdate.getText());
		Assert.assertEquals(Integer.valueOf(-168975658), boardPostUpdate.getTopicOwnerId());
		Assert.assertEquals(Integer.valueOf(41499874), boardPostUpdate.getTopicId());
	}
}
