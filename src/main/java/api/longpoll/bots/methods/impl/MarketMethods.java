package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.market.EditOrder;
import api.longpoll.bots.methods.impl.market.GetGroupOrders;
import api.longpoll.bots.methods.impl.market.GetOrderById;
import api.longpoll.bots.methods.impl.market.GetOrderItems;

/**
 * Provides Market methods.
 */
public class MarketMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public MarketMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public EditOrder editOrder() {
        return new EditOrder(accessToken);
    }

    public GetGroupOrders getGroupOrders() {
        return new GetGroupOrders(accessToken);
    }

    public GetOrderById getOrderById() {
        return new GetOrderById(accessToken);
    }

    public GetOrderItems getOrderItems() {
        return new GetOrderItems(accessToken);
    }
}
