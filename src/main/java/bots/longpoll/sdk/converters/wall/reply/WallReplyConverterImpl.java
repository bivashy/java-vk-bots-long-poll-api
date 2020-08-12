package bots.longpoll.sdk.converters.wall.reply;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.photo.PhotoCommentUpdateConverterImpl;
import bots.longpoll.sdk.model.wall.reply.WallReply;
import com.google.gson.JsonObject;

public class WallReplyConverterImpl extends JsonToPojoConverter<WallReply> {
	private PhotoCommentUpdateConverterImpl photoCommentUpdateConverter = new PhotoCommentUpdateConverterImpl();

	@Override
	public WallReply convert(JsonObject jsonObject) {
		return photoCommentUpdateConverter.convert(jsonObject);
	}
}
