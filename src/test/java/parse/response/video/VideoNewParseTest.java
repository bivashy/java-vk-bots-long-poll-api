package parse.response.video;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.objects.media.Video;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class VideoNewParseTest {
    @Test
    void videoNew() {
        Update event = ParseUtil.getFirstEvent("json/response/video_new/video_new_sample_5_110.json");
        assertEquals(Update.Type.VIDEO_NEW, event.getType());
        assertEquals(333, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof Video);

        Video video = (Video) object;
        assertTrue(video.getCanEdit());
        assertTrue(video.getCanAdd());
        assertEquals(0, video.getCommentsAmount());
        assertEquals(1594821406, video.getDate());
        assertFalse(video.getDescription().isEmpty());
        assertEquals(314, video.getDuration());
        assertEquals(111, video.getId());
        assertEquals(-222, video.getOwnerId());
        String title = video.getTitle();
        assertNotNull(title);
        assertFalse(title.isEmpty());
        assertFalse(video.getFavourite());
        assertEquals("video", video.getType());
        assertEquals(1, video.getViews());
        assertEquals(0, video.getLocalViews());
        assertEquals("YouTube", video.getPlatform());
    }
}
