package bots.longpoll.sdk.converters.audio;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.audio.Audio;
import com.google.gson.JsonObject;

public class AudioConverterImpl extends JsonToPojoConverter<Audio> {
	@Override
	public Audio convert(JsonObject source) {
		return gson.fromJson(source, Audio.class);
	}
}
