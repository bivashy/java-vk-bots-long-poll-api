package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
 * Describes price.
 *
 * @see <a href="https://vk.com/dev/price">Price</a>
 */
public class Price {
	/**
	 * Integer price value multiplied by 100.
	 */
	@SerializedName("amount")
	private Integer amount;

	/**
	 * Price currency.
	 */
	@SerializedName("currency")
	private Currency currency;

	/**
	 * Localized price and currency.
	 */
	@SerializedName("text")
	private String text;

	public Integer getAmount() {
		return amount;
	}

	public Price setAmount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Price setCurrency(Currency currency) {
		this.currency = currency;
		return this;
	}

	public String getText() {
		return text;
	}

	public Price setText(String text) {
		this.text = text;
		return this;
	}
}