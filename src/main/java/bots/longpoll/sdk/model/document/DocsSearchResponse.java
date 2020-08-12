package bots.longpoll.sdk.model.document;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DocsSearchResponse {
	@SerializedName("count")
	private Integer count;
	@SerializedName("items")
	List<Document> items;

	public Integer getCount() {
		return count;
	}

	public DocsSearchResponse setCount(Integer count) {
		this.count = count;
		return this;
	}

	public List<Document> getItems() {
		return items;
	}

	public DocsSearchResponse setItems(List<Document> items) {
		this.items = items;
		return this;
	}
}
