package bots.longpoll.sdk.model.video;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class VideoCommentDeleteUpdate extends UpdateObject {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("deleter_id")
	private Integer deleterId;
	@SerializedName("video_id")
	private Integer videoId;
	@SerializedName("user_id")
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public VideoCommentDeleteUpdate setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public VideoCommentDeleteUpdate setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getDeleterId() {
		return deleterId;
	}

	public VideoCommentDeleteUpdate setDeleterId(Integer deleterId) {
		this.deleterId = deleterId;
		return this;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public VideoCommentDeleteUpdate setVideoId(Integer videoId) {
		this.videoId = videoId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public VideoCommentDeleteUpdate setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
}
