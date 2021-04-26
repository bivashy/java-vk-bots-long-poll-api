package api.longpoll.bots.model.response.market;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.response.GenericResult;

/**
 * Response to <b>market.getGroupOrders</b> request.
 */
public class MarketGetGroupOrdersResult extends GenericResult<VkList<MarketOrder>> {
}
