package parse.response.photo;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.wall.reply.Thread;
import bots.longpoll.sdk.model.photos.PhotoCommentUpdate;
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
public class PhotoCommentEditParseTest extends AbstractParseTest {
	@Test
	public void test1_messageEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/photo_comment_edit/photo_comment_edit_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2614), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("photo_comment_edit", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("24c4fd1d5d9ad88cd714b91364e6737f2cff2814", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof PhotoCommentUpdate);
		PhotoCommentUpdate photoCommentUpdate = (PhotoCommentUpdate) updateObject;
		Assert.assertNotNull(photoCommentUpdate);
		Assert.assertEquals(Integer.valueOf(3), photoCommentUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), photoCommentUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(1594285508), photoCommentUpdate.getDate());
		Assert.assertEquals("tt", photoCommentUpdate.getText());
		Assert.assertEquals(Integer.valueOf(-168975658), photoCommentUpdate.getPhotoOwnerId());
		Assert.assertEquals(Integer.valueOf(457239017), photoCommentUpdate.getPhotoId());

		Thread thread = photoCommentUpdate.getThread();
		Assert.assertNotNull(thread);
		Assert.assertEquals(Integer.valueOf(0), thread.getCount());
	}
}
