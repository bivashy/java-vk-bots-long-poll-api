package bots.longpoll.sdk.model.wall.post;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import bots.longpoll.sdk.model.wall.reply.WallReplyLikes;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class WallPostLikes extends WallReplyLikes {
	@SerializedName("can_publish")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canPublish;

	public boolean isCanPublish() {
		return canPublish;
	}

	public WallPostLikes setCanPublish(boolean canPublish) {
		this.canPublish = canPublish;
		return this;
	}
}
