package bots.longpoll.sdk.model.market.item;

import bots.longpoll.sdk.model.link.product.Price;
import com.google.gson.annotations.SerializedName;

public class ItemPrice extends Price {
	@SerializedName("old_amount")
	private Integer oldAmount;

	public Integer getOldAmount() {
		return oldAmount;
	}

	public ItemPrice setOldAmount(Integer oldAmount) {
		this.oldAmount = oldAmount;
		return this;
	}
}
