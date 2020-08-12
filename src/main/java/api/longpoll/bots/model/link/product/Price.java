package api.longpoll.bots.model.link.product;

import com.google.gson.annotations.SerializedName;

public class Price {
	@SerializedName("amount")
	private Integer amount;
	@SerializedName("currency")
	private Currency currency;
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
