package api.longpoll.bots.converters.wall.reply;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.wall.reply.WallReply;
import api.longpoll.bots.converters.photo.PhotoCommentUpdateConverterImpl;
import com.google.gson.JsonObject;

public class WallReplyConverterImpl extends JsonToPojoConverter<WallReply> {
	private PhotoCommentUpdateConverterImpl photoCommentUpdateConverter = new PhotoCommentUpdateConverterImpl();

	@Override
	public WallReply convert(JsonObject jsonObject) {
		return photoCommentUpdateConverter.convert(jsonObject);
	}
}
