package parse.response.photo;

import api.longpoll.bots.converters.response.events.GetEventsResultConverter;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.photos.PhotoCommentEvent;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.basic.WallComment;
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
public class PhotoCommentRestoreParseTest extends AbstractParseTest {
    @Test
    public void test1_messageEdit() throws IOException {
        JsonObject jsonObject = readJson("json/response/photo_comment_restore/photo_comment_restore_sample_5_110.json");
        GetEventsResult getEventsResult = new GetEventsResultConverter().convert(jsonObject);
        Assert.assertNotNull(getEventsResult);
        Assert.assertEquals(Integer.valueOf(2616), getEventsResult.getTs());

        List<Event> events = getEventsResult.getEvents();
        Assert.assertNotNull(events);
        Assert.assertEquals(1, events.size());

        Event event = events.get(0);
        Assert.assertNotNull(event);
        Assert.assertEquals(EventType.PHOTO_COMMENT_RESTORE, event.getType());
        Assert.assertEquals(Integer.valueOf(444), event.getGroupId());
        Assert.assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        Assert.assertNotNull(eventObject);

        Assert.assertTrue(eventObject instanceof PhotoCommentEvent);
        PhotoCommentEvent photoCommentUpdate = (PhotoCommentEvent) eventObject;
        Assert.assertNotNull(photoCommentUpdate);
        Assert.assertEquals(Integer.valueOf(3), photoCommentUpdate.getId());
        Assert.assertEquals(Integer.valueOf(111), photoCommentUpdate.getFromId());
        Assert.assertEquals(Integer.valueOf(1594285508), photoCommentUpdate.getDate());
        Assert.assertEquals("tt", photoCommentUpdate.getText());
        Assert.assertEquals(Integer.valueOf(-222), photoCommentUpdate.getPhotoOwnerId());
        Assert.assertEquals(Integer.valueOf(333), photoCommentUpdate.getPhotoId());

        WallComment.Thread thread = photoCommentUpdate.getThread();
        Assert.assertNotNull(thread);
        Assert.assertEquals(Integer.valueOf(0), thread.getCount());
    }
}
