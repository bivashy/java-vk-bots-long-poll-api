package parse.response.video;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.video.VideoComment;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class VideoCommentNewParseTest {
    @Test
    void videoCommentNew() {
        Update event = ParseUtil.getFirstEvent("json/response/video_comment_new/video_comment_new_sample_5_110.json");
        assertEquals(Update.Type.VIDEO_COMMENT_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof VideoComment);

        VideoComment videoCommentUpdate = (VideoComment) object;
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
