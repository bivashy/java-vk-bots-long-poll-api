package parse.response.video;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.video.VideoCommentEvent;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class VideoCommentRestoreParseTest {
    @Test
    void videoCommentRestore() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/video_comment_restore/video_comment_restore_sample_5_110.json");
        assertEquals(EventType.VIDEO_COMMENT_RESTORE, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof VideoCommentEvent);

        VideoCommentEvent videoCommentUpdate = (VideoCommentEvent) eventObject;
        assertEquals(2, videoCommentUpdate.getId());
        assertEquals(111, videoCommentUpdate.getFromId());
        assertEquals(1594834849, videoCommentUpdate.getDate());
        assertEquals("t", videoCommentUpdate.getText());
        assertEquals(-222, videoCommentUpdate.getVideoOwnerId());
        assertEquals(333, videoCommentUpdate.getVideoId());

        WallComment.Thread thread = videoCommentUpdate.getThread();
        assertNotNull(thread);
        assertEquals(0, thread.getCount());
    }
}
