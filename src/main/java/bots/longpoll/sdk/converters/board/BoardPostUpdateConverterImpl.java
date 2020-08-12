package bots.longpoll.sdk.converters.board;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.board.BoardPostUpdate;
import com.google.gson.JsonObject;

public class BoardPostUpdateConverterImpl extends JsonToPojoConverter<BoardPostUpdate> {
	@Override
	public BoardPostUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, BoardPostUpdate.class);
	}
}
