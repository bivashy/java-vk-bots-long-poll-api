package api.longpoll.bots.methods.market;

import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.model.response.market.MarketGetOrderByIdResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>market.getOrderById</b> method.
 * <p>
 * Returns order by id.
 *
 * @see <a href="https://vk.com/dev/market.getOrderById">https://vk.com/dev/market.getOrderById</a>
 */
public class MarketGetOrderById extends VkApiGetMethod<MarketGetOrderByIdResult> {
    /**
     * User ID.
     */
    private Integer userId;

    /**
     * Order ID.
     */
    private Integer orderId;

    /**
     * Whether method should return extended Order details.
     */
    private Boolean extended;

    public MarketGetOrderById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("market.getOrderById");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("user_id", userId),
                keyVal("order_id", orderId),
                keyVal("extended", extended, true)
        );
    }

    @Override
    protected Class<? extends MarketGetOrderByIdResult> getResultType() {
        return MarketGetOrderByIdResult.class;
    }

    public MarketGetOrderById setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public MarketGetOrderById setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public MarketGetOrderById setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }
}
