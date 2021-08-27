package api.longpoll.bots.methods.impl.market;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.response.GenericResponse;

/**
 * Implements <b>market.getGroupOrders</b> method.
 * <p>
 * Returns community's orders.
 *
 * @see <a href="https://vk.com/dev/market.getGroupOrders">https://vk.com/dev/market.getGroupOrders</a>
 */
public class GetGroupOrders extends AuthorizedVkApiMethod<GetGroupOrders.Response> {
    public GetGroupOrders(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("market.getGroupOrders");
    }

    @Override
    protected Class<Response> getResultType() {
        return Response.class;
    }

    public GetGroupOrders setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public GetGroupOrders setOffset(int offset) {
        addParam("offset", offset);
        return this;
    }

    public GetGroupOrders setCount(int count) {
        addParam("count", count);
        return this;
    }

    /**
     * Response to <b>market.getGroupOrders</b> request.
     */
    public static class Response extends GenericResponse<VkList<MarketOrder>> {
    }
}
