package bots.longpoll.sdk.converters.wall.reply;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.wall.reply.WallReplyUpdate;
import com.google.gson.JsonObject;

public class WallReplyUpdateConverterImpl extends JsonToPojoConverter<WallReplyUpdate> {
	@Override
	public WallReplyUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, WallReplyUpdate.class);
	}
}
