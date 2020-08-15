package parse.response.photo;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.photos.PhotoCommentDeleteEvent;
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
public class PhotoCommentDeleteParseTest extends AbstractParseTest {
	@Test
	public void test1_messageEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/photo_comment_delete/photo_comment_delete_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2615), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("photo_comment_delete", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("bcaa59d39d90c7f655b172c992ca43b96e81c8ca", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof PhotoCommentDeleteEvent);
		PhotoCommentDeleteEvent photoCommentDeleteUpdate = (PhotoCommentDeleteEvent) eventObject;
		Assert.assertNotNull(photoCommentDeleteUpdate);
		Assert.assertEquals(Integer.valueOf(-168975658), photoCommentDeleteUpdate.getOwnerId());
		Assert.assertEquals(Integer.valueOf(3), photoCommentDeleteUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), photoCommentDeleteUpdate.getDeleterId());
		Assert.assertEquals(Integer.valueOf(457239017), photoCommentDeleteUpdate.getPhotoId());
		Assert.assertEquals(Integer.valueOf(381980625), photoCommentDeleteUpdate.getUserId());
	}
}
