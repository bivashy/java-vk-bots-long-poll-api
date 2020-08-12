package parse.response.photo;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.photos.PhotoCommentDeleteUpdate;
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
public class PhotoCommentDeleteParseTest extends AbstractParseTest {
	@Test
	public void test1_messageEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/photo_comment_delete/photo_comment_delete_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2615), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("photo_comment_delete", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("bcaa59d39d90c7f655b172c992ca43b96e81c8ca", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof PhotoCommentDeleteUpdate);
		PhotoCommentDeleteUpdate photoCommentDeleteUpdate = (PhotoCommentDeleteUpdate) updateObject;
		Assert.assertNotNull(photoCommentDeleteUpdate);
		Assert.assertEquals(Integer.valueOf(-168975658), photoCommentDeleteUpdate.getOwnerId());
		Assert.assertEquals(Integer.valueOf(3), photoCommentDeleteUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), photoCommentDeleteUpdate.getDeleterId());
		Assert.assertEquals(Integer.valueOf(457239017), photoCommentDeleteUpdate.getPhotoId());
		Assert.assertEquals(Integer.valueOf(381980625), photoCommentDeleteUpdate.getUserId());
	}
}
