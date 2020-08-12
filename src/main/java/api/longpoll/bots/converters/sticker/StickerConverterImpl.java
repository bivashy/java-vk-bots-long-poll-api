package api.longpoll.bots.converters.sticker;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.sticker.Sticker;
import com.google.gson.JsonObject;

public class StickerConverterImpl extends JsonToPojoConverter<Sticker> {
	@Override
	public Sticker convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, Sticker.class);
	}
}
