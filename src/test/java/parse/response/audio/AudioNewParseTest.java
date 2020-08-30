package parse.response.audio;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.objects.media.Audio;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
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
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2618), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("audio_new", event.getType());
		Assert.assertEquals(Integer.valueOf(123), event.getGroupId());
		Assert.assertEquals("abc", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof Audio);
		Audio audio = (Audio) eventObject;
		Assert.assertEquals("Rick Astley", audio.getArtist());
		Assert.assertEquals(Integer.valueOf(456239017), audio.getId());
		Assert.assertEquals(Integer.valueOf(-111), audio.getOwnerId());
		Assert.assertEquals("Never Gonna Give You Up", audio.getTitle());
		Assert.assertEquals(Integer.valueOf(211), audio.getDuration());
		Assert.assertTrue(audio.getUrl().isEmpty());
		Assert.assertEquals(Integer.valueOf(1594822421), audio.getDate());
	}
}
