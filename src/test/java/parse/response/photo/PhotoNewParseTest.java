package parse.response.photo;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.photos.Photo;
import bots.longpoll.sdk.model.photos.Size;
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
public class PhotoNewParseTest extends AbstractParseTest {
	@Test
	public void test1_messageEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/photo_new/photo_new_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2612), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("photo_new", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("ddc5e5b73765f5a56eae81814be72889a4f511ea", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof Photo);
		Photo photo = (Photo) updateObject;
		Assert.assertNotNull(photo);
		Assert.assertEquals(Integer.valueOf(255186642), photo.getAlbumId());
		Assert.assertEquals(Integer.valueOf(1594284077), photo.getDate());
		Assert.assertEquals(Integer.valueOf(457239017), photo.getId());
		Assert.assertEquals(Integer.valueOf(-168975658), photo.getOwnerId());
		Assert.assertFalse(photo.hasText());
		Assert.assertEquals(Integer.valueOf(100), photo.getUserId());

		List<Size> sizes = photo.getSizes();
		Assert.assertNotNull(photo);
		Assert.assertFalse(sizes.isEmpty());
	}
}
