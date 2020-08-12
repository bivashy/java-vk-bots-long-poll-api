package parse.response.audio;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.audio.Audio;
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
public class AudioNewParseTest extends AbstractParseTest {
	@Test
	public void test1_audioNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/audio_new/audio_new_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2618), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("audio_new", update.getType());
		Assert.assertEquals(Integer.valueOf(168975658), update.getGroupId());
		Assert.assertEquals("35a535e65e5b35837a0fc0c07f26e2d0cf11450a", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof Audio);
		Audio audio = (Audio) updateObject;
		Assert.assertEquals("Rick Astley", audio.getArtist());
		Assert.assertEquals(Integer.valueOf(456239017), audio.getId());
		Assert.assertEquals(Integer.valueOf(-168975658), audio.getOwnerId());
		Assert.assertEquals("Never Gonna Give You Up", audio.getTitle());
		Assert.assertEquals(Integer.valueOf(211), audio.getDuration());
		Assert.assertFalse(audio.isExplicit());
		Assert.assertFalse(audio.isFocusTrack());
		Assert.assertEquals("485a78a6qghyMJRnAYPVpvLMTORD7n1p", audio.getTrackCode());
		Assert.assertTrue(audio.getUrl().isEmpty());
		Assert.assertEquals(Integer.valueOf(1594822421), audio.getDate());
		Assert.assertFalse(audio.isShortVidoesAllowed());
		Assert.assertFalse(audio.isStoriesAllowed());
	}
}
