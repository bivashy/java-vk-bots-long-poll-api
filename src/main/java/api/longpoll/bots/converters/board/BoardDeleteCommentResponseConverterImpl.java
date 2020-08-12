package api.longpoll.bots.converters.board;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.board.BoardDeleteCommentResponse;
import com.google.gson.JsonObject;

public class BoardDeleteCommentResponseConverterImpl extends JsonToPojoConverter<BoardDeleteCommentResponse> {
	@Override
	public BoardDeleteCommentResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, BoardDeleteCommentResponse.class);
	}
}
