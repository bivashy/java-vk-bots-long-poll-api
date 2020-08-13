package api.longpoll.bots.methods.board;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.IntegerResult;

public class BoardRestoreComment extends GetMethod<IntegerResult> {
	private static final String GROUP_ID = "group_id";
	private static final String TOPIC_ID = "topic_id";
	private static final String COMMENT_ID = "comment_id";

	public BoardRestoreComment setGroupId(int groupId) {
		params.put(GROUP_ID, groupId);
		return this;
	}

	public BoardRestoreComment setTopicId(int topicId) {
		params.put(TOPIC_ID, topicId);
		return this;
	}

	public BoardRestoreComment setCommentId(int commentId) {
		params.put(COMMENT_ID, commentId);
		return this;
	}

	public BoardRestoreComment(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Board.RESTORE_COMMENT;
	}

	@Override
	protected JsonToPojoConverter<IntegerResult> getConverter() {
		return GenericConverterFactory.get(IntegerResult.class);
	}
}
