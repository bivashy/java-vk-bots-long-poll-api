package api.longpoll.bots.converters.market;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.market.item.MarketCommentEvent;
import com.google.gson.JsonObject;

public class MarketCommentUpdateConverterImpl extends JsonToPojoConverter<MarketCommentEvent> {
	@Override
	public MarketCommentEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MarketCommentEvent.class);
	}
}
