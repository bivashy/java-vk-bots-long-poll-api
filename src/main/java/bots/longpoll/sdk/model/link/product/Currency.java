package bots.longpoll.sdk.model.link.product;

import com.google.gson.annotations.SerializedName;

public class Currency {
	@SerializedName("id")
	private Integer id;
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
