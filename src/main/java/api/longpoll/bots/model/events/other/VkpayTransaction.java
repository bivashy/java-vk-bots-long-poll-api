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

	public VkpayTransaction setFromId(Integer fromId) {
		this.fromId = fromId;
		return this;
	}

	public Integer getAmount() {
		return amount;
	}

	public VkpayTransaction setAmount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public VkpayTransaction setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public VkpayTransaction setDate(Integer date) {
		this.date = date;
		return this;
	}
}
