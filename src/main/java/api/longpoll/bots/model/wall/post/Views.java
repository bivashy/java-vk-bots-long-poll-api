package api.longpoll.bots.model.wall.post;

import com.google.gson.annotations.SerializedName;

public class Views {
	@SerializedName("count")
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public Views setCount(Integer count) {
		this.count = count;
		return this;
	}
}
