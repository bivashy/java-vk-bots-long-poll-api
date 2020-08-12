package bots.longpoll.sdk.converters.market;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import com.google.gson.JsonObject;
import bots.longpoll.sdk.model.market.order.MarketOrder;

public class MarketOrderConverterImpl extends JsonToPojoConverter<MarketOrder> {
	@Override
	public MarketOrder convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MarketOrder.class);
	}
}
