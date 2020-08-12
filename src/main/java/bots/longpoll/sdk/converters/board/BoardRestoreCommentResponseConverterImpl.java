package bots.longpoll.sdk.converters.board;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.board.BoardRestoreCommentResponse;
import com.google.gson.JsonObject;

public class BoardRestoreCommentResponseConverterImpl extends JsonToPojoConverter<BoardRestoreCommentResponse> {
	@Override
	public BoardRestoreCommentResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, BoardRestoreCommentResponse.class);
	}
}
