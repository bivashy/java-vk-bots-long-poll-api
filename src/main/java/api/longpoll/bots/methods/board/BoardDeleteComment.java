package api.longpoll.bots.methods.board;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>board.deleteComment</b> method.
 *
 * Deletes a comment on a topic on a community's discussion board.
 *
 * @see <a href="https://vk.com/dev/board.deleteComment">https://vk.com/dev/board.deleteComment</a>
 */
public class BoardDeleteComment extends VkApiGetMethod<IntegerResult> {
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

    public BoardDeleteComment(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().boardDeleteComment();
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

    public BoardDeleteComment setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public BoardDeleteComment setTopicId(Integer topicId) {
        this.topicId = topicId;
        return this;
    }

    public BoardDeleteComment setCommentId(Integer commentId) {
        this.commentId = commentId;
        return this;
    }
}
