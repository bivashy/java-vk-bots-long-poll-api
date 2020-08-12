package api.longpoll.bots.converters.video;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.video.VideoCommentDeleteEvent;
import com.google.gson.JsonObject;

public class VideoCommentDeleteUpdateConverterImpl extends JsonToPojoConverter<VideoCommentDeleteEvent> {
	@Override
	public VideoCommentDeleteEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, VideoCommentDeleteEvent.class);
	}
}
