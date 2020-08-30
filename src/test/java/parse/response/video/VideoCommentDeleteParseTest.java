package parse.response.video;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.events.video.VideoCommentDeleteEvent;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoCommentDeleteParseTest extends AbstractParseTest {
    @Test
    public void test1_videoCommentDelete() throws IOException {
        JsonObject jsonObject = readJson("json/response/video_comment_delete/video_comment_delete_sample_5_110.json");
        GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
        Assert.assertNotNull(getEventsResult);
        Assert.assertEquals(Integer.valueOf(2622), getEventsResult.getTs());

        List<Event> events = getEventsResult.getEvents();
        Assert.assertNotNull(events);
        Assert.assertEquals(1, events.size());

        Event event = events.get(0);
        Assert.assertNotNull(event);
        Assert.assertEquals("video_comment_delete", event.getType());
        Assert.assertEquals(Integer.valueOf(444), event.getGroupId());
        Assert.assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        Assert.assertNotNull(eventObject);

        Assert.assertTrue(eventObject instanceof VideoCommentDeleteEvent);
        VideoCommentDeleteEvent videoCommentDeleteUpdate = (VideoCommentDeleteEvent) eventObject;
        Assert.assertEquals(Integer.valueOf(1), videoCommentDeleteUpdate.getId());
        Assert.assertEquals(Integer.valueOf(-111), videoCommentDeleteUpdate.getOwnerId());
        Assert.assertEquals(Integer.valueOf(222), videoCommentDeleteUpdate.getDeleterId());
        Assert.assertEquals(Integer.valueOf(333), videoCommentDeleteUpdate.getVideoId());
    }
}
