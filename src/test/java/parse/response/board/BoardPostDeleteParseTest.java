package parse.response.board;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.board.BoardPostDeleteUpdate;
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
public class BoardPostDeleteParseTest extends AbstractParseTest {
	@Test
	public void test1_boardReplyNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/board_post_delete/board_post_delete_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2638), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("board_post_delete", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("af54f48154aac42f20b57f03d754ba2496497291", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof BoardPostDeleteUpdate);
		BoardPostDeleteUpdate boardPostDeleteUpdate = (BoardPostDeleteUpdate) updateObject;
		Assert.assertEquals(Integer.valueOf(-168975658), boardPostDeleteUpdate.getTopicOwnerId());
		Assert.assertEquals(Integer.valueOf(3), boardPostDeleteUpdate.getId());
		Assert.assertEquals(Integer.valueOf(41499874), boardPostDeleteUpdate.getTopicId());
	}
}
