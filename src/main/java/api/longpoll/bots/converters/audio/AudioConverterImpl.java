package api.longpoll.bots.converters.audio;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.audio.Audio;
import com.google.gson.JsonObject;

public class AudioConverterImpl extends JsonToPojoConverter<Audio> {
	@Override
	public Audio convert(JsonObject source) {
		return gson.fromJson(source, Audio.class);
	}
}
