package bots.longpoll.sdk.converters.wall.reply;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.wall.reply.WallReplyDeleteUpdate;
import com.google.gson.JsonObject;

public class WallReplyDeleteUpdateConverterImpl extends JsonToPojoConverter<WallReplyDeleteUpdate> {
	@Override
	public WallReplyDeleteUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, WallReplyDeleteUpdate.class);
	}
}
