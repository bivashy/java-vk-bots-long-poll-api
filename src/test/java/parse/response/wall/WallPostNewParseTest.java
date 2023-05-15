package parse.response.wall;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.objects.basic.WallPost;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class WallPostNewParseTest {
    @Test
    void wallPostNew() {
        Update event = ParseUtil.getFirstEvent("json/response/wall_post_new/wall_post_new_sample_5_110.json");
        assertEquals(Update.Type.WALL_POST_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertNotNull(object);

        assertTrue(object instanceof WallPost);
        WallPost wallPost = (WallPost) object;
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

        WallPost.Copyright copyright = wallPost.getCopyright();
        assertNotNull(copyright);
        assertEquals("external_link", copyright.getType());
        assertEquals("github.com", copyright.getName());
        assertEquals("https://github.com/", copyright.getLink());
    }
}
