package api.longpoll.bots.converters.wall.reply;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.wall.reply.WallReplyDeleteEvent;
import com.google.gson.JsonObject;

public class WallReplyDeleteUpdateConverterImpl extends JsonToPojoConverter<WallReplyDeleteEvent> {
	@Override
	public WallReplyDeleteEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, WallReplyDeleteEvent.class);
	}
}
