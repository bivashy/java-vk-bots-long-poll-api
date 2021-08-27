package api.longpoll.bots.methods.impl.market;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.media.MarketItem;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>market.getOrderItems</b> method.
 * <p>
 * Returns items of an order.
 *
 * @see <a href="https://vk.com/dev/market.getOrderItems">https://vk.com/dev/market.getOrderItems</a>
 */
public class GetOrderItems extends AuthorizedVkApiMethod<GetOrderItems.Response> {
    public GetOrderItems(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("market.getOrderItems");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetOrderItems setUserId(int userId) {
        addParam("user_id", userId);
        return this;
    }

    public GetOrderItems setOrderId(int orderId) {
        addParam("order_id", orderId);
        return this;
    }

    public GetOrderItems setOffset(int offset) {
        addParam("offset", offset);
        return this;
    }

    public GetOrderItems setCount(int count) {
        addParam("count", count);
        return this;
    }

    /**
     * Response to <b>market.getOrderItems</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject extends MarketItem {
            /**
             * Product quantity.
             */
            @SerializedName("quantity")
            private int quantity;

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }


            @Override
            public String toString() {
                return "ResponseObject{" +
                        "quantity=" + quantity +
                        "} " + super.toString();
            }
        }
    }
}
