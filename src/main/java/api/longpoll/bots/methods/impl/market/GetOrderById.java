package api.longpoll.bots.methods.impl.market;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
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
public class GetOrderById extends AuthorizedVkApiMethod<GetOrderById.Response> {
    public GetOrderById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
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
        return addParam("extended", new BoolInt(extended));
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
