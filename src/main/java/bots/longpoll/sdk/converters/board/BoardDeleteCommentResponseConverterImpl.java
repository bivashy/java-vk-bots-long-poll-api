package bots.longpoll.sdk.converters.board;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.board.BoardDeleteCommentResponse;
import com.google.gson.JsonObject;

public class BoardDeleteCommentResponseConverterImpl extends JsonToPojoConverter<BoardDeleteCommentResponse> {
	@Override
	public BoardDeleteCommentResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, BoardDeleteCommentResponse.class);
	}
}
