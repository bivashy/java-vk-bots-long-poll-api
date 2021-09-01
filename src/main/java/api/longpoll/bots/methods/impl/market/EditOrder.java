package api.longpoll.bots.methods.impl.market;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>market.editOrder</b> method.
 * <p>
 * Edits an order.
 *
 * @see <a href="https://vk.com/dev/market.editOrder">https://vk.com/dev/market.editOrder</a>
 */
public class EditOrder extends AuthorizedVkApiMethod<IntegerResponse> {
    public EditOrder(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("market.editOrder");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public EditOrder setUserId(int userId) {
        addParam("user_id", userId);
        return this;
    }

    public EditOrder setOrderId(int orderId) {
        addParam("order_id", orderId);
        return this;
    }

    public EditOrder setMerchantComment(String merchantComment) {
        addParam("merchant_comment", merchantComment);
        return this;
    }

    public EditOrder setStatus(int status) {
        addParam("status", status);
        return this;
    }

    public EditOrder setTrackNumber(String trackNumber) {
        addParam("track_number", trackNumber);
        return this;
    }

    public EditOrder setPaymentStatus(String paymentStatus) {
        addParam("payment_status", paymentStatus);
        return this;
    }

    public EditOrder setDeliveryPrice(int deliveryPrice) {
        addParam("delivery_price", deliveryPrice);
        return this;
    }

    public EditOrder setWidth(int width) {
        addParam("width", width);
        return this;
    }

    public EditOrder setLength(int length) {
        addParam("length", length);
        return this;
    }

    public EditOrder setHeight(int height) {
        addParam("height", height);
        return this;
    }

    public EditOrder setWeight(int weight) {
        addParam("weight", weight);
        return this;
    }

    public EditOrder setCommentForUser(String commentForUser) {
        addParam("comment_for_user", commentForUser);
        return this;
    }

    public EditOrder setReceiptLink(String receiptLink) {
        addParam("receipt_link", receiptLink);
        return this;
    }
}
