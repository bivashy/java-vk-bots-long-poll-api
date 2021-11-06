package api.longpoll.bots.methods.impl.market;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.response.GenericResponse;

/**
 * Implements <b>market.getOrderById</b> method.
 * <p>
 * Returns order by id.
 *
 * @see <a href="https://vk.com/dev/market.getOrderById">https://vk.com/dev/market.getOrderById</a>
 */
public class GetOrderById extends VkMethod<GetOrderById.Response> {
    private final Converter<Boolean, Integer> boolIntConverter = VkBotsConfig.getInstance().getBoolIntConverter();

    public GetOrderById(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkApiProperties.get("market.getOrderById");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetOrderById setUserId(int userId) {
        return addParam("user_id", userId);
    }

    public GetOrderById setOrderId(int orderId) {
        return addParam("order_id", orderId);
    }

    public GetOrderById setExtended(boolean extended) {
        return addParam("extended", boolIntConverter.convert(extended));
    }

    @Override
    public GetOrderById addParam(String key, Object value) {
        return (GetOrderById) super.addParam(key, value);
    }

    /**
     * Response to <b>market.getOrderById</b> request.
     */
    public static class Response extends GenericResponse<MarketOrder> {
    }
}
