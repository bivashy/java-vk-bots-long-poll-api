package api.longpoll.bots.methods.board;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetExecutor;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.board.BoardRestoreCommentResponse;

public class BoardRestoreComment extends GetExecutor<BoardRestoreCommentResponse> {
	private static final String GROUP_ID = "group_id";
	private static final String TOPIC_ID = "topic_id";
	private static final String COMMENT_ID = "comment_id";

	public BoardRestoreComment setGroupId(int groupId) {
		params.put(GROUP_ID, groupId);
		return this;
	}

	public int getGroupId() {
		return (int) params.get(GROUP_ID);
	}

	public BoardRestoreComment setTopicId(int topicId) {
		params.put(TOPIC_ID, topicId);
		return this;
	}

	public int getTopicId() {
		return (int) params.get(TOPIC_ID);
	}

	public BoardRestoreComment setCommentId(int commentId) {
		params.put(COMMENT_ID, commentId);
		return this;
	}

	public int getCommentId() {
		return (int) params.get(COMMENT_ID);
	}

	public BoardRestoreComment(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Board.RESTORE_COMMENT;
	}

	@Override
	protected JsonToPojoConverter<BoardRestoreCommentResponse> getConverter() {
		return GenericConverterFactory.get(BoardRestoreCommentResponse.class);
	}
}
