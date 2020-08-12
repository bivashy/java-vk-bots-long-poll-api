package api.longpoll.bots.model.market.order;

import com.google.gson.annotations.SerializedName;

public class Recipient {
	@SerializedName("name")
	private String name;
	@SerializedName("phone")
	private String phone;
	@SerializedName("display_text")
	private String display_text;

	public String getName() {
		return name;
	}

	public Recipient setName(String name) {
		this.name = name;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Recipient setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getDisplay_text() {
		return display_text;
	}

	public Recipient setDisplay_text(String display_text) {
		this.display_text = display_text;
		return this;
	}
}
