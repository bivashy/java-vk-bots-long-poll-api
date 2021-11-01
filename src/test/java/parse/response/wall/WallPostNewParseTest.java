package parse.response.wall;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.objects.basic.WallPost;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class WallPostNewParseTest {
    @Test
    void wallPostNew() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/wall_post_new/wall_post_new_sample_5_110.json");
        assertEquals(EventType.WALL_POST_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertNotNull(eventObject);

        assertTrue(eventObject instanceof WallPost);
        WallPost wallPost = (WallPost) eventObject;
        assertEquals(1, wallPost.getId());
        assertEquals(111, wallPost.getFromId());
        assertEquals(-222, wallPost.getOwnerId());
        assertEquals(1594888935, wallPost.getDate());
        assertFalse(wallPost.getMarkedAsAds());
        assertEquals("post", wallPost.getPostType());
        assertEquals("test", wallPost.getText());
        assertTrue(wallPost.getCanEdit());
        assertEquals(333, wallPost.getCreatedBy());
        assertTrue(wallPost.getCanDelete());
        assertFalse(wallPost.getFavourite());

        WallPost.Comments comments = wallPost.getComments();
        assertNotNull(comments);
        assertEquals(0, comments.getCount());
    }
}
