package parse.response.video;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.basic.WallComment;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.events.video.VideoCommentEvent;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoCommentNewParseTest extends AbstractParseTest {
	@Test
	public void test1_videoCommentNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/video_comment_new/video_comment_new_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2619), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("video_comment_new", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("a4f2f918304676aeff8825cfe55a20f5a9a7547d", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof VideoCommentEvent);
		VideoCommentEvent videoCommentUpdate = (VideoCommentEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(1), videoCommentUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), videoCommentUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(1594823317), videoCommentUpdate.getDate());
		Assert.assertEquals("check", videoCommentUpdate.getText());
		Assert.assertEquals(Integer.valueOf(-168975658), videoCommentUpdate.getVideoOwnerId());
		Assert.assertEquals(Integer.valueOf(456239017), videoCommentUpdate.getVideoId());

		WallComment.Thread thread = videoCommentUpdate.getThread();
		Assert.assertNotNull(thread);
		Assert.assertEquals(Integer.valueOf(0), thread.getCount());
	}
}
