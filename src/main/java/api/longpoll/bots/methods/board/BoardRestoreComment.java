package api.longpoll.bots.methods.board;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>board.deleteComment</b> method.
 *
 * @see <a href="https://vk.com/dev/board.deleteComment">https://vk.com/dev/board.deleteComment</a>
 */
public class BoardRestoreComment extends GetMethod<GenericResult<Integer>> {
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

    public BoardRestoreComment(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().boardRestoreComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>() {}.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("topic_id", topicId),
                keyVal("comment_id", commentId)
        );
    }

    public Integer getGroupId() {
        return groupId;
    }

    public BoardRestoreComment setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public BoardRestoreComment setTopicId(Integer topicId) {
        this.topicId = topicId;
        return this;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public BoardRestoreComment setCommentId(Integer commentId) {
        this.commentId = commentId;
        return this;
    }
}
