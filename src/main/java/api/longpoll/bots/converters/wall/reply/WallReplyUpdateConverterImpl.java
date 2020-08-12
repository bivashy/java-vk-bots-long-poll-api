package api.longpoll.bots.converters.wall.reply;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.wall.reply.WallReplyEvent;
import com.google.gson.JsonObject;

public class WallReplyUpdateConverterImpl extends JsonToPojoConverter<WallReplyEvent> {
	@Override
	public WallReplyEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, WallReplyEvent.class);
	}
}
