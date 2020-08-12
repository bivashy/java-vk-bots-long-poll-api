package bots.longpoll.sdk.model.wall.reply;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Thread {
	@SerializedName("count")
	private Integer count;
	@SerializedName("can_post")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canPost;
	@SerializedName("show_reply_button")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean showReplyButton;
	@SerializedName("groups_can_post")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean groupsCanPost;

	public Integer getCount() {
		return count;
	}

	public Thread setCount(Integer count) {
		this.count = count;
		return this;
	}

	public boolean isCanPost() {
		return canPost;
	}

	public Thread setCanPost(boolean canPost) {
		this.canPost = canPost;
		return this;
	}

	public boolean isShowReplyButton() {
		return showReplyButton;
	}

	public Thread setShowReplyButton(boolean showReplyButton) {
		this.showReplyButton = showReplyButton;
		return this;
	}

	public boolean isGroupsCanPost() {
		return groupsCanPost;
	}

	public Thread setGroupsCanPost(boolean groupsCanPost) {
		this.groupsCanPost = groupsCanPost;
		return this;
	}
}
