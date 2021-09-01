package api.longpoll.bots.methods.impl.board;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>board.deleteComment</b> method.
 *
 * Deletes a comment on a topic on a community's discussion board.
 *
 * @see <a href="https://vk.com/dev/board.deleteComment">https://vk.com/dev/board.deleteComment</a>
 */
public class DeleteComment extends AuthorizedVkApiMethod<IntegerResponse> {
    public DeleteComment(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("board.deleteComment");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public DeleteComment setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public DeleteComment setTopicId(int topicId) {
        addParam("topic_id", topicId);
        return this;
    }

    public DeleteComment setCommentId(int commentId) {
        addParam("comment_id", commentId);
        return this;
    }
}
