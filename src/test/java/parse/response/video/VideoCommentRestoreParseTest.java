package parse.response.video;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.video.VideoComment;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class VideoCommentRestoreParseTest {
    @Test
    void videoCommentRestore() {
        Update event = ParseUtil.getFirstEvent("json/response/video_comment_restore/video_comment_restore_sample_5_110.json");
        assertEquals(Update.Type.VIDEO_COMMENT_RESTORE, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof VideoComment);

        VideoComment videoCommentUpdate = (VideoComment) object;
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
