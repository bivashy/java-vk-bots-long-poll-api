package parse.response.video;

import api.longpoll.bots.converters.response.events.GetEventsResultConverter;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
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
public class VideoCommentRestoreParseTest extends AbstractParseTest {
    @Test
    public void test1_videoCommentRestore() throws IOException {
        JsonObject jsonObject = readJson("json/response/video_comment_restore/video_comment_restore_sample_5_110.json");
        GetEventsResult getEventsResult = new GetEventsResultConverter().convert(jsonObject);
        Assert.assertNotNull(getEventsResult);
        Assert.assertEquals(Integer.valueOf(2625), getEventsResult.getTs());

        List<Event> events = getEventsResult.getEvents();
        Assert.assertNotNull(events);
        Assert.assertEquals(1, events.size());

        Event event = events.get(0);
        Assert.assertNotNull(event);
        Assert.assertEquals(EventType.VIDEO_COMMENT_RESTORE, event.getType());
        Assert.assertEquals(Integer.valueOf(444), event.getGroupId());
        Assert.assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        Assert.assertNotNull(eventObject);

        Assert.assertTrue(eventObject instanceof VideoCommentEvent);
        VideoCommentEvent videoCommentUpdate = (VideoCommentEvent) eventObject;
        Assert.assertEquals(Integer.valueOf(2), videoCommentUpdate.getId());
        Assert.assertEquals(Integer.valueOf(111), videoCommentUpdate.getFromId());
        Assert.assertEquals(Integer.valueOf(1594834849), videoCommentUpdate.getDate());
        Assert.assertEquals("t", videoCommentUpdate.getText());
        Assert.assertEquals(Integer.valueOf(-222), videoCommentUpdate.getVideoOwnerId());
        Assert.assertEquals(Integer.valueOf(333), videoCommentUpdate.getVideoId());

        WallComment.Thread thread = videoCommentUpdate.getThread();
        Assert.assertNotNull(thread);
        Assert.assertEquals(Integer.valueOf(0), thread.getCount());
    }
}
