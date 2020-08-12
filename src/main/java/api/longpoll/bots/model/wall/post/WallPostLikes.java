package api.longpoll.bots.model.wall.post;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.wall.reply.WallReplyLikes;
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
