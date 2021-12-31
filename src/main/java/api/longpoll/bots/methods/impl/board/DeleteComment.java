package api.longpoll.bots.methods.impl.board;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>board.deleteComment</b> method.
 * <p>
 * Deletes a comment on a topic on a community's discussion board.
 *
 * @see <a href="https://vk.com/dev/board.deleteComment">https://vk.com/dev/board.deleteComment</a>
 */
public class DeleteComment extends VkMethod<IntegerResponse> {
    public DeleteComment(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("board.deleteComment");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public DeleteComment setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public DeleteComment setTopicId(int topicId) {
        return addParam("topic_id", topicId);
    }

    public DeleteComment setCommentId(int commentId) {
        return addParam("comment_id", commentId);
    }

    @Override
    public DeleteComment addParam(String key, Object value) {
        return (DeleteComment) super.addParam(key, value);
    }
}
