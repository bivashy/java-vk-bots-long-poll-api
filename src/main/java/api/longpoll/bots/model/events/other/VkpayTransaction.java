package api.longpoll.bots.model.events.other;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>vkpay_transaction</b> event objects.
 */
public class VkpayTransaction implements EventObject {
    /**
     * User ID who initiated the transaction.
     */
    @SerializedName("from_id")
    private Integer fromId;

    /**
     * Transaction amount in thousandths of rubles.
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * Transaction comment.
     */
    @SerializedName("description")
    private String description;

    /**
     * Time of sending the transaction in Unixtime.
     */
    @SerializedName("date")
    private Integer date;

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "VkpayTransaction{" +
                "fromId=" + fromId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
