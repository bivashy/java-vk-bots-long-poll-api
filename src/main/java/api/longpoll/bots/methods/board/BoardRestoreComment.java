package api.longpoll.bots.methods.board;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>board.deleteComment</b> method.
 *
 * Restores a comment deleted from a topic on a community's discussion board.
 *
 * @see <a href="https://vk.com/dev/board.deleteComment">https://vk.com/dev/board.deleteComment</a>
 */
public class BoardRestoreComment extends VkApiGetMethod<IntegerResult> {
    /**
     * ID of the community that owns the discussion board.
     */
    private Integer groupId;

    /**
     * Topic ID.
     */
    private Integer topicId;

    /**
     * Comment ID.
     */
    private Integer commentId;

    public BoardRestoreComment(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().boardRestoreComment();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("topic_id", topicId),
                keyVal("comment_id", commentId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public BoardRestoreComment setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public BoardRestoreComment setTopicId(Integer topicId) {
        this.topicId = topicId;
        return this;
    }

    public BoardRestoreComment setCommentId(Integer commentId) {
        this.commentId = commentId;
        return this;
    }
}
