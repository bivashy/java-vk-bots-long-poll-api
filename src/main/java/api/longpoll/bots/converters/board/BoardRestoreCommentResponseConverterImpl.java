package api.longpoll.bots.converters.board;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.board.BoardRestoreCommentResponse;
import com.google.gson.JsonObject;

public class BoardRestoreCommentResponseConverterImpl extends JsonToPojoConverter<BoardRestoreCommentResponse> {
	@Override
	public BoardRestoreCommentResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, BoardRestoreCommentResponse.class);
	}
}
