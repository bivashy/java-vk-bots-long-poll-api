package bots.longpoll.sdk.model.wall.reply;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class WallReplyDeleteUpdate extends UpdateObject {
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("id")
	private Integer id;
	@SerializedName("deleter_id")
	private Integer deleterId;
	@SerializedName("post_id")
	private Integer postId;

	public Integer getOwnerId() {
		return ownerId;
	}

	public WallReplyDeleteUpdate setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public WallReplyDeleteUpdate setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getDeleterId() {
		return deleterId;
	}

	public WallReplyDeleteUpdate setDeleterId(Integer deleterId) {
		this.deleterId = deleterId;
		return this;
	}

	public Integer getPostId() {
		return postId;
	}

	public WallReplyDeleteUpdate setPostId(Integer postId) {
		this.postId = postId;
		return this;
	}
}
