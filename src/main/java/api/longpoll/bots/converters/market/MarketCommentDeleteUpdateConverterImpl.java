package api.longpoll.bots.converters.market;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.market.item.MarketCommentDeleteEvent;
import com.google.gson.JsonObject;

public class MarketCommentDeleteUpdateConverterImpl extends JsonToPojoConverter<MarketCommentDeleteEvent> {
	@Override
	public MarketCommentDeleteEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MarketCommentDeleteEvent.class);
	}
}
