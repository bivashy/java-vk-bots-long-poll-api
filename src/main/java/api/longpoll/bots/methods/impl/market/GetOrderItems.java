package api.longpoll.bots.methods.impl.market;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.media.MarketItem;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>market.getOrderItems</b> method.
 * <p>
 * Returns items of an order.
 *
 * @see <a href="https://vk.com/dev/market.getOrderItems">https://vk.com/dev/market.getOrderItems</a>
 */
public class GetOrderItems extends VkMethod<GetOrderItems.ResponseBody> {
    public GetOrderItems(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("market.getOrderItems");
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetOrderItems setUserId(int userId) {
        return addParam("user_id", userId);
    }

    public GetOrderItems setOrderId(int orderId) {
        return addParam("order_id", orderId);
    }

    public GetOrderItems setOffset(int offset) {
        return addParam("offset", offset);
    }

    public GetOrderItems setCount(int count) {
        return addParam("count", count);
    }

    @Override
    public GetOrderItems addParam(String key, Object value) {
        return (GetOrderItems) super.addParam(key, value);
    }

    /**
     * Response to <b>market.getOrderItems</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response extends MarketItem {
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
                return "Response{" +
                        "quantity=" + quantity +
                        "} " + super.toString();
            }
        }
    }
}
