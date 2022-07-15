package parse.response.video;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.video.VideoCommentDelete;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class VideoCommentDeleteParseTest {
    @Test
    void videoCommentDelete() {
        Update event = ParseUtil.getFirstEvent("json/response/video_comment_delete/video_comment_delete_sample_5_110.json");
        assertEquals(Update.Type.VIDEO_COMMENT_DELETE, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof VideoCommentDelete);

        VideoCommentDelete videoCommentDeleteUpdate = (VideoCommentDelete) object;
        assertEquals(1, videoCommentDeleteUpdate.getId());
        assertEquals(-111, videoCommentDeleteUpdate.getOwnerId());
        assertEquals(222, videoCommentDeleteUpdate.getDeleterId());
        assertEquals(333, videoCommentDeleteUpdate.getVideoId());
    }
}
