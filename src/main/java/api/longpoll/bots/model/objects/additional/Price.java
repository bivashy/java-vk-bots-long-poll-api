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

	/**
	 * Describes currency.
	 */
	public class Currency {
		/**
		 * Currency ID.
		 */
		@SerializedName("id")
		private Integer id;

		/**
		 * Currency letter.
		 */
		@SerializedName("name")
		private String name;

		public Integer getId() {
			return id;
		}

		public Currency setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getName() {
			return name;
		}

		public Currency setName(String name) {
			this.name = name;
			return this;
		}
	}

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