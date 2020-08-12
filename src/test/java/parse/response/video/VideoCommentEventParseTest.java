package parse.response.video;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.video.VideoCommentEvent;
import api.longpoll.bots.model.wall.reply.Thread;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoCommentEventParseTest extends AbstractParseTest {
	@Test
	public void test1_videoCommentEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/video_comment_edit/video_comment_edit_sample_5_110.json");
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2621), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("video_comment_edit", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("54fc108b84a26341b710a0abd1d94dcaf2d8b059", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof VideoCommentEvent);
		VideoCommentEvent videoCommentUpdate = (VideoCommentEvent) eventObject;
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
