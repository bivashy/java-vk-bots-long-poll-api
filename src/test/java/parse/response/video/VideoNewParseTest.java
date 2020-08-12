package parse.response.video;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
import bots.longpoll.sdk.model.video.Video;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoNewParseTest extends AbstractParseTest {
	@Test
	public void test1_videoNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/video_new/video_new_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2617), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("video_new", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("4955483c90a79925320074e95d37f296bfc70cb4", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof Video);
		Video video = (Video) updateObject;
		Assert.assertTrue(video.isCanEdit());
		Assert.assertTrue(video.isCanAdd());
		Assert.assertEquals(Integer.valueOf(0), video.getCommentsAmount());
		Assert.assertEquals(Integer.valueOf(1594821406), video.getDate());
		Assert.assertFalse(video.getDescription().isEmpty());
		Assert.assertEquals(Integer.valueOf(314), video.getDuration());
		Assert.assertEquals(Integer.valueOf(456239017), video.getId());
		Assert.assertEquals(Integer.valueOf(-168975658), video.getOwnerId());
		Assert.assertFalse(video.getTitle().isEmpty());
		Assert.assertFalse(video.isFavourite());
		Assert.assertEquals("video", video.getType());
		Assert.assertEquals(Integer.valueOf(1), video.getViews());
		Assert.assertEquals(Integer.valueOf(0), video.getLocalViews());
		Assert.assertEquals("YouTube", video.getPlatform());
	}
}
