package bots.longpoll.sdk.converters.audio.message;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.audio.message.AudioMessage;
import com.google.gson.JsonObject;

public class AudioMessageConverterImpl extends JsonToPojoConverter<AudioMessage> {
	@Override
	public AudioMessage convert(JsonObject source) {
		return gson.fromJson(source, AudioMessage.class);
	}
}
