package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.market.EditOrder;
import api.longpoll.bots.methods.impl.market.GetGroupOrders;
import api.longpoll.bots.methods.impl.market.GetOrderById;
import api.longpoll.bots.methods.impl.market.GetOrderItems;

/**
 * Provides Market methods.
 */
public class MarketApi extends AbstractVkApi {
    public MarketApi(String accessToken) {
        super(accessToken);
    }

    public EditOrder editOrder() {
        return new EditOrder(getAccessToken());
    }

    public GetGroupOrders getGroupOrders() {
        return new GetGroupOrders(getAccessToken());
    }

    public GetOrderById getOrderById() {
        return new GetOrderById(getAccessToken());
    }

    public GetOrderItems getOrderItems() {
        return new GetOrderItems(getAccessToken());
    }
}
