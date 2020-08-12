package parse.response.video;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
import bots.longpoll.sdk.model.video.VideoCommentDeleteUpdate;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoCommentDeleteParseTest extends AbstractParseTest {
	@Test
	public void test1_videoCommentDelete() throws IOException {
		JsonObject jsonObject = readJson("json/response/video_comment_delete/video_comment_delete_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2622), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("video_comment_delete", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("c790943c674f5cd91396f351cbc0aa60285e3c86", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof VideoCommentDeleteUpdate);
		VideoCommentDeleteUpdate videoCommentDeleteUpdate = (VideoCommentDeleteUpdate) updateObject;
		Assert.assertEquals(Integer.valueOf(1), videoCommentDeleteUpdate.getId());
		Assert.assertEquals(Integer.valueOf(-168975658), videoCommentDeleteUpdate.getOwnerId());
		Assert.assertEquals(Integer.valueOf(381980625), videoCommentDeleteUpdate.getDeleterId());
		Assert.assertEquals(Integer.valueOf(456239017), videoCommentDeleteUpdate.getVideoId());
	}
}
