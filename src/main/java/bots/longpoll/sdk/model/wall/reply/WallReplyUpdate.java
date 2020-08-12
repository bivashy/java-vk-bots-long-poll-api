package bots.longpoll.sdk.model.wall.reply;

import com.google.gson.annotations.SerializedName;

public class WallReplyUpdate extends WallReply {
	@SerializedName("post_owner_id")
	private Integer postOwnerId;

	public Integer getPostOwnerId() {
		return postOwnerId;
	}

	public WallReplyUpdate setPostOwnerId(Integer postOwnerId) {
		this.postOwnerId = postOwnerId;
		return this;
	}
}
