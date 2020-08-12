package api.longpoll.bots.converters.market;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.market.order.MarketOrder;
import com.google.gson.JsonObject;

public class MarketOrderConverterImpl extends JsonToPojoConverter<MarketOrder> {
	@Override
	public MarketOrder convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MarketOrder.class);
	}
}
