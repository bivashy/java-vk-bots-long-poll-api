package api.longpoll.bots.model.link.product;

import com.google.gson.annotations.SerializedName;

public class Product {
	@SerializedName("price")
	private Price price;

	public boolean hasPrice() {
		return price != null;
	}

	public Price getPrice() {
		return price;
	}

	public Product setPrice(Price price) {
		this.price = price;
		return this;
	}
}
