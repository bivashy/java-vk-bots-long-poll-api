package bots.longpoll.sdk.executors.board;

import bots.longpoll.sdk.LongPollBot;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.board.BoardDeleteCommentResponseConverterImpl;
import bots.longpoll.sdk.executors.GetExecutor;
import bots.longpoll.sdk.executors.VkApi;
import bots.longpoll.sdk.model.board.BoardDeleteCommentResponse;

public class BoardDeleteComment extends GetExecutor<BoardDeleteCommentResponse> {
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
	protected JsonToPojoConverter<BoardDeleteCommentResponse> getConverter() {
		return new BoardDeleteCommentResponseConverterImpl();
	}
}
