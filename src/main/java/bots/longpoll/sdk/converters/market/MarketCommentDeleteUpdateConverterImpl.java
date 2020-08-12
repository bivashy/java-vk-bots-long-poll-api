package bots.longpoll.sdk.converters.market;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.market.item.MarketCommentDeleteUpdate;
import com.google.gson.JsonObject;

public class MarketCommentDeleteUpdateConverterImpl extends JsonToPojoConverter<MarketCommentDeleteUpdate> {
	@Override
	public MarketCommentDeleteUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MarketCommentDeleteUpdate.class);
	}
}
