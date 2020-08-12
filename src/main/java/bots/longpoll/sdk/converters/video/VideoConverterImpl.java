package bots.longpoll.sdk.converters.video;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.video.Video;
import com.google.gson.JsonObject;

public class VideoConverterImpl extends JsonToPojoConverter<Video> {
	@Override
	public Video convert(JsonObject source) {
		return gson.fromJson(source, Video.class);
	}
}
