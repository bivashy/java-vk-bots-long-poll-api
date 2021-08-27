package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.market.GetGroupOrders;
import api.longpoll.bots.methods.impl.market.GetOrderById;

/**
 * Provides Market methods.
 */
public class MarketApi extends AbstractVkApi {
    public MarketApi(String accessToken) {
        super(accessToken);
    }

    public GetGroupOrders getGroupOrders() {
        return new GetGroupOrders(getAccessToken());
    }

    public GetOrderById getOrderById() {
        return new GetOrderById(getAccessToken());
    }
}
