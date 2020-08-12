package bots.longpoll.sdk.converters.video;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.video.VideoCommentDeleteUpdate;
import com.google.gson.JsonObject;

public class VideoCommentDeleteUpdateConverterImpl extends JsonToPojoConverter<VideoCommentDeleteUpdate> {
	@Override
	public VideoCommentDeleteUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, VideoCommentDeleteUpdate.class);
	}
}
