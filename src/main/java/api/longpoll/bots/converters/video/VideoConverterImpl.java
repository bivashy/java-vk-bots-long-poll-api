package api.longpoll.bots.converters.video;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.video.Video;
import com.google.gson.JsonObject;

public class VideoConverterImpl extends JsonToPojoConverter<Video> {
	@Override
	public Video convert(JsonObject source) {
		return gson.fromJson(source, Video.class);
	}
}
