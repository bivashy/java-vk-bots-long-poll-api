package api.longpoll.bots.methods.board;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.IntegerResult;

public class BoardDeleteComment extends GetMethod<IntegerResult> {
	private static final String GROUP_ID = "group_id";
	private static final String TOPIC_ID = "topic_id";
	private static final String COMMENT_ID = "comment_id";

	public BoardDeleteComment setGroupId(int groupId) {
		params.put(GROUP_ID, groupId);
		return this;
	}

	public int getGroupId() {
		return (int) params.get(GROUP_ID);
	}

	public BoardDeleteComment setTopicId(int topicId) {
		params.put(TOPIC_ID, topicId);
		return this;
	}

	public int getTopicId() {
		return (int) params.get(TOPIC_ID);
	}

	public BoardDeleteComment setCommentId(int commentId) {
		params.put(COMMENT_ID, commentId);
		return this;
	}

	public int getCommentId() {
		return (int) params.get(COMMENT_ID);
	}

	public BoardDeleteComment(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Board.DELETE_COMMENT;
	}

	@Override
	protected JsonToPojoConverter<IntegerResult> getConverter() {
		return GenericConverterFactory.get(IntegerResult.class);
	}
}
