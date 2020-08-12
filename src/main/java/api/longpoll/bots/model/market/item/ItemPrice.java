package api.longpoll.bots.model.market.item;

import api.longpoll.bots.model.link.product.Price;
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
