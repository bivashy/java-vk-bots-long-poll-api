package api.longpoll.bots.methods.board;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class BoardDeleteComment extends GetMethod<GenericResult<Integer>> {
	private Integer groupId;
	private Integer topicId;
	private Integer commentId;

	public BoardDeleteComment(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Board.DELETE_COMMENT;
	}

	@Override
	protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
		return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
	}

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

	public BoardDeleteComment setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public BoardDeleteComment setTopicId(Integer topicId) {
		this.topicId = topicId;
		return this;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public BoardDeleteComment setCommentId(Integer commentId) {
		this.commentId = commentId;
		return this;
	}
}
