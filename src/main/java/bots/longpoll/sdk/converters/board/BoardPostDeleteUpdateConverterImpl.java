package bots.longpoll.sdk.converters.board;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.board.BoardPostDeleteUpdate;
import com.google.gson.JsonObject;

public class BoardPostDeleteUpdateConverterImpl extends JsonToPojoConverter<BoardPostDeleteUpdate> {
	@Override
	public BoardPostDeleteUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, BoardPostDeleteUpdate.class);
	}
}
