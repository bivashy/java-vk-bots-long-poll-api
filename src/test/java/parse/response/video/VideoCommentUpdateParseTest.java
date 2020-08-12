package parse.response.video;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
import bots.longpoll.sdk.model.video.VideoCommentUpdate;
import bots.longpoll.sdk.model.wall.reply.Thread;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoCommentUpdateParseTest extends AbstractParseTest {
	@Test
	public void test1_videoCommentEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/video_comment_edit/video_comment_edit_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2621), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("video_comment_edit", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("54fc108b84a26341b710a0abd1d94dcaf2d8b059", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof VideoCommentUpdate);
		VideoCommentUpdate videoCommentUpdate = (VideoCommentUpdate) updateObject;
		Assert.assertEquals(Integer.valueOf(1), videoCommentUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), videoCommentUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(1594823317), videoCommentUpdate.getDate());
		Assert.assertEquals("check2", videoCommentUpdate.getText());
		Assert.assertEquals(Integer.valueOf(-168975658), videoCommentUpdate.getVideoOwnerId());
		Assert.assertEquals(Integer.valueOf(456239017), videoCommentUpdate.getVideoId());

		Thread thread = videoCommentUpdate.getThread();
		Assert.assertNotNull(thread);
		Assert.assertEquals(Integer.valueOf(0), thread.getCount());
	}
}
