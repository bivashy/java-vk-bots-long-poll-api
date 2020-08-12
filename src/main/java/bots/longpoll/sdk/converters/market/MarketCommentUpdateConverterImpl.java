package bots.longpoll.sdk.converters.market;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.market.item.MarketCommentUpdate;
import com.google.gson.JsonObject;

public class MarketCommentUpdateConverterImpl extends JsonToPojoConverter<MarketCommentUpdate> {
	@Override
	public MarketCommentUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MarketCommentUpdate.class);
	}
}
