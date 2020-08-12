package api.longpoll.bots.converters.audio.message;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.audio.message.AudioMessage;
import com.google.gson.JsonObject;

public class AudioMessageConverterImpl extends JsonToPojoConverter<AudioMessage> {
	@Override
	public AudioMessage convert(JsonObject source) {
		return gson.fromJson(source, AudioMessage.class);
	}
}
