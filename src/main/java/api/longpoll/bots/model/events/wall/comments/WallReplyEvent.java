package api.longpoll.bots.model.events.wall.comments;

import api.longpoll.bots.model.objects.basic.WallComment;
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
