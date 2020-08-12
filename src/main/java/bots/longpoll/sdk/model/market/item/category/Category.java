package bots.longpoll.sdk.model.market.item.category;

import com.google.gson.annotations.SerializedName;

public class Category {
	@SerializedName("id")
	private Integer id;
	@SerializedName("name")
	private String name;
	@SerializedName("section")
	private Section section;

	public Integer getId() {
		return id;
	}

	public Category setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}

	public Section getSection() {
		return section;
	}

	public Category setSection(Section section) {
		this.section = section;
		return this;
	}
}
