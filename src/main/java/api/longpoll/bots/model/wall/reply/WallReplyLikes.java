package api.longpoll.bots.model.wall.reply;

import api.longpoll.bots.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class WallReplyLikes {
	@SerializedName("count")
	private Integer count;
	@SerializedName("user_likes")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean userLikes;
	@SerializedName("can_like")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canLike;

	public Integer getCount() {
		return count;
	}

	public WallReplyLikes setCount(Integer count) {
		this.count = count;
		return this;
	}

	public boolean isUserLikes() {
		return userLikes;
	}

	public WallReplyLikes setUserLikes(boolean userLikes) {
		this.userLikes = userLikes;
		return this;
	}

	public boolean isCanLike() {
		return canLike;
	}

	public WallReplyLikes setCanLike(boolean canLike) {
		this.canLike = canLike;
		return this;
	}
}
