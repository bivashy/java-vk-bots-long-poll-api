package api.longpoll.bots.model.market.item.category;

import com.google.gson.annotations.SerializedName;

public class Section {
	@SerializedName("id")
	private Integer id;
	@SerializedName("name")
	private String name;

	public Integer getId() {
		return id;
	}

	public Section setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Section setName(String name) {
		this.name = name;
		return this;
	}
}
