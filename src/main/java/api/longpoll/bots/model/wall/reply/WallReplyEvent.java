package api.longpoll.bots.model.wall.reply;

import com.google.gson.annotations.SerializedName;

public class WallReplyEvent extends WallComment {
	@SerializedName("post_owner_id")
	private Integer postOwnerId;

	public Integer getPostOwnerId() {
		return postOwnerId;
	}

	public WallReplyEvent setPostOwnerId(Integer postOwnerId) {
		this.postOwnerId = postOwnerId;
		return this;
	}
}
