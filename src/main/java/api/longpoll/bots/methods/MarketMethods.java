package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.market.EditOrder;
import api.longpoll.bots.methods.impl.market.GetGroupOrders;
import api.longpoll.bots.methods.impl.market.GetOrderById;
import api.longpoll.bots.methods.impl.market.GetOrderItems;

import java.util.function.Supplier;

/**
 * Provides Market methods.
 */
public class MarketMethods {
    /**
     * {@code access_token}.
     */
    private final Supplier<String> accessTokenSupplier;

    public MarketMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public EditOrder editOrder() {
        return new EditOrder(accessTokenSupplier.get());
    }

    public GetGroupOrders getGroupOrders() {
        return new GetGroupOrders(accessTokenSupplier.get());
    }

    public GetOrderById getOrderById() {
        return new GetOrderById(accessTokenSupplier.get());
    }

    public GetOrderItems getOrderItems() {
        return new GetOrderItems(accessTokenSupplier.get());
    }
}
