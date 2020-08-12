package api.longpoll.bots.converters.board;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.board.BoardPostDeleteEvent;
import com.google.gson.JsonObject;

public class BoardPostDeleteUpdateConverterImpl extends JsonToPojoConverter<BoardPostDeleteEvent> {
	@Override
	public BoardPostDeleteEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, BoardPostDeleteEvent.class);
	}
}
