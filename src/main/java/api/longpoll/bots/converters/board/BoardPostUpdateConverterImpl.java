package api.longpoll.bots.converters.board;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.board.BoardPostEvent;
import com.google.gson.JsonObject;

public class BoardPostUpdateConverterImpl extends JsonToPojoConverter<BoardPostEvent> {
	@Override
	public BoardPostEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, BoardPostEvent.class);
	}
}
