package parse.response.video;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.video.VideoCommentDeleteEvent;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class VideoCommentDeleteParseTest {
    @Test
    void videoCommentDelete() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/video_comment_delete/video_comment_delete_sample_5_110.json");
        assertEquals(EventType.VIDEO_COMMENT_DELETE, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof VideoCommentDeleteEvent);

        VideoCommentDeleteEvent videoCommentDeleteUpdate = (VideoCommentDeleteEvent) eventObject;
        assertEquals(1, videoCommentDeleteUpdate.getId());
        assertEquals(-111, videoCommentDeleteUpdate.getOwnerId());
        assertEquals(222, videoCommentDeleteUpdate.getDeleterId());
        assertEquals(333, videoCommentDeleteUpdate.getVideoId());
    }
}
