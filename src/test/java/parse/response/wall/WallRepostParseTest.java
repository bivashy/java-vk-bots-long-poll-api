package parse.response.wall;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.objects.basic.WallPost;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WallRepostParseTest {
    @Test
    void wallRepost() {
        Update event = ParseUtil.getFirstEvent("json/response/wall_repost/wall_repost_sample_5_110.json");
        assertEquals(Update.Type.WALL_REPOST, event.getType());
        assertEquals(555, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);
        assertTrue(object instanceof WallPost);

        WallPost wallPost = (WallPost) object;
        assertEquals(34, wallPost.getId());
        assertEquals(111, wallPost.getFromId());
        assertEquals(222, wallPost.getOwnerId());
        assertEquals(1594890511, wallPost.getDate());
        assertEquals("post", wallPost.getPostType());
        assertEquals("", wallPost.getText());
        assertTrue(wallPost.getCanArchive());
        assertFalse(wallPost.getArchived());
        assertFalse(wallPost.getFavourite());

        WallPost.Comments comments = wallPost.getComments();
        assertNotNull(comments);
        assertEquals(0, comments.getCount());

        List<WallPost> copyHistory = wallPost.getCopyHistory();
        assertNotNull(copyHistory);
        assertFalse(copyHistory.isEmpty());

        WallPost post = copyHistory.get(0);
        assertNotNull(post);
        assertEquals(3, post.getId());
        assertEquals(-333, post.getOwnerId());
        assertEquals(-444, post.getFromId());
        assertEquals(1594890485, post.getDate());
        assertEquals("post", post.getPostType());
        assertEquals("test", post.getText());

        WallPost.PostSource postSource = post.getPostSource();
        assertNotNull(postSource);
        assertEquals("vk", postSource.getType());
    }
}
