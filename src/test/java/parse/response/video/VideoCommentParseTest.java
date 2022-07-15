package parse.response.video;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.video.VideoComment;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class VideoCommentParseTest {
    @Test
    void videoCommentEdit() {
        Update event = ParseUtil.getFirstEvent("json/response/video_comment_edit/video_comment_edit_sample_5_110.json");
        assertEquals(Update.Type.VIDEO_COMMENT_EDIT, event.getType());
        assertEquals(555, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof VideoComment);

        VideoComment videoCommentUpdate = (VideoComment) object;
        assertEquals(1, videoCommentUpdate.getId());
        assertEquals(111, videoCommentUpdate.getFromId());
        assertEquals(222, videoCommentUpdate.getDate());
        assertEquals("check2", videoCommentUpdate.getText());
        assertEquals(-333, videoCommentUpdate.getVideoOwnerId());
        assertEquals(444, videoCommentUpdate.getVideoId());

        WallComment.Thread thread = videoCommentUpdate.getThread();
        assertNotNull(thread);
        assertEquals(0, thread.getCount());
    }
}
