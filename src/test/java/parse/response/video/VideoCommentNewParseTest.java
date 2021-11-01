package parse.response.video;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.video.VideoCommentEvent;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class VideoCommentNewParseTest {
    @Test
    void videoCommentNew() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/video_comment_new/video_comment_new_sample_5_110.json");
        assertEquals(EventType.VIDEO_COMMENT_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof VideoCommentEvent);

        VideoCommentEvent videoCommentUpdate = (VideoCommentEvent) eventObject;
        assertEquals(1, videoCommentUpdate.getId());
        assertEquals(111, videoCommentUpdate.getFromId());
        assertEquals(1594823317, videoCommentUpdate.getDate());
        assertEquals("check", videoCommentUpdate.getText());
        assertEquals(-222, videoCommentUpdate.getVideoOwnerId());
        assertEquals(333, videoCommentUpdate.getVideoId());

        WallComment.Thread thread = videoCommentUpdate.getThread();
        assertNotNull(thread);
        assertEquals(0, thread.getCount());
    }
}
