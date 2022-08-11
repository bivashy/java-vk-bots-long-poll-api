package api.longpoll.bots.methods.impl.board;

import api.longpoll.bots.methods.VkBotsMethods;
import api.longpoll.bots.model.response.IntegerResponseBody;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestoreCommentTest {
    VkBotsMethods vk = new VkBotsMethods("access_token");

    @Test
    void restoreCommentCreation() {
        RestoreComment restoreComment = vk.board.restoreComment()
                .setGroupId(1)
                .setTopicId(2)
                .setCommentId(3);

        assertEquals("https://api.vk.com/method/board.restoreComment", restoreComment.getUri());
        assertEquals(IntegerResponseBody.class, restoreComment.getResponseClass());
//        assertEquals("1", restoreComment.getParams().get("group_id"));
//        assertEquals("2", restoreComment.getParams().get("topic_id"));
//        assertEquals("3", restoreComment.getParams().get("comment_id"));
    }
}