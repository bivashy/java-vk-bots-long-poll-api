package api.longpoll.bots.methods.impl.board;

import api.longpoll.bots.methods.VkBotsMethods;
import api.longpoll.bots.model.response.IntegerResponseBody;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCommentTest {
    VkBotsMethods vk = new VkBotsMethods("access_token");

    @Test
    void deleteCommentCreation() {
        DeleteComment deleteComment = vk.board.deleteComment()
                .setGroupId(1)
                .setTopicId(2)
                .setCommentId(3);

        assertEquals("https://api.vk.com/method/board.deleteComment", deleteComment.getUri());
        assertEquals(IntegerResponseBody.class, deleteComment.getResponseType());
//        assertEquals("1", deleteComment.getParams().get("group_id"));
//        assertEquals("2", deleteComment.getParams().get("topic_id"));
//        assertEquals("3", deleteComment.getParams().get("comment_id"));
    }
}