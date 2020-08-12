package bots.longpoll.sdk.model.wall.post;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Reposts {
	@SerializedName("count")
	private Integer count;
	@SerializedName("user_reposted")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean userReposted;

	public Integer getCount() {
		return count;
	}

	public Reposts setCount(Integer count) {
		this.count = count;
		return this;
	}

	public boolean isUserReposted() {
		return userReposted;
	}

	public Reposts setUserReposted(boolean userReposted) {
		this.userReposted = userReposted;
		return this;
	}
}
