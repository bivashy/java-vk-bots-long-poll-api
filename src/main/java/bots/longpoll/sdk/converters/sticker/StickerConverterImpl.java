package bots.longpoll.sdk.converters.sticker;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.sticker.Sticker;
import com.google.gson.JsonObject;

public class StickerConverterImpl extends JsonToPojoConverter<Sticker> {
	@Override
	public Sticker convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, Sticker.class);
	}
}
