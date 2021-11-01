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
        return addParam("user_id", userId);
    }

    public EditOrder setOrderId(int orderId) {
        return addParam("order_id", orderId);
    }

    public EditOrder setMerchantComment(String merchantComment) {
        return addParam("merchant_comment", merchantComment);
    }

    public EditOrder setStatus(int status) {
        return addParam("status", status);
    }

    public EditOrder setTrackNumber(String trackNumber) {
        return addParam("track_number", trackNumber);
    }

    public EditOrder setPaymentStatus(String paymentStatus) {
        return addParam("payment_status", paymentStatus);
    }

    public EditOrder setDeliveryPrice(int deliveryPrice) {
        return addParam("delivery_price", deliveryPrice);
    }

    public EditOrder setWidth(int width) {
        return addParam("width", width);
    }

    public EditOrder setLength(int length) {
        return addParam("length", length);
    }

    public EditOrder setHeight(int height) {
        return addParam("height", height);
    }

    public EditOrder setWeight(int weight) {
        return addParam("weight", weight);
    }

    public EditOrder setCommentForUser(String commentForUser) {
        return addParam("comment_for_user", commentForUser);
    }

    public EditOrder setReceiptLink(String receiptLink) {
        return addParam("receipt_link", receiptLink);
    }

    @Override
    public EditOrder addParam(String key, Object value) {
        return (EditOrder) super.addParam(key, value);
    }
}
