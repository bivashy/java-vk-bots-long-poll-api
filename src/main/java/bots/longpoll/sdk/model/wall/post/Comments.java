package bots.longpoll.sdk.model.wall.post;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Comments {
	@SerializedName("count")
	private Integer count;
	@SerializedName("can_post")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canPost;
	@SerializedName("groups_can_post")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean groupsCanPost;
	@SerializedName("can_close")
	private boolean canClose;
	@SerializedName("can_open")
	private boolean canOpen;

	public Integer getCount() {
		return count;
	}

	public Comments setCount(Integer count) {
		this.count = count;
		return this;
	}

	public boolean isCanPost() {
		return canPost;
	}

	public Comments setCanPost(boolean canPost) {
		this.canPost = canPost;
		return this;
	}

	public boolean isGroupsCanPost() {
		return groupsCanPost;
	}

	public Comments setGroupsCanPost(boolean groupsCanPost) {
		this.groupsCanPost = groupsCanPost;
		return this;
	}

	public boolean isCanClose() {
		return canClose;
	}

	public Comments setCanClose(boolean canClose) {
		this.canClose = canClose;
		return this;
	}

	public boolean isCanOpen() {
		return canOpen;
	}

	public Comments setCanOpen(boolean canOpen) {
		this.canOpen = canOpen;
		return this;
	}
}
