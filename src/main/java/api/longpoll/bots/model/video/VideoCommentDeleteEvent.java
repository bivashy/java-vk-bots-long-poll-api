package api.longpoll.bots.model.video;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class VideoCommentDeleteEvent extends EventObject {
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

	public VideoCommentDeleteEvent setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public VideoCommentDeleteEvent setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getDeleterId() {
		return deleterId;
	}

	public VideoCommentDeleteEvent setDeleterId(Integer deleterId) {
		this.deleterId = deleterId;
		return this;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public VideoCommentDeleteEvent setVideoId(Integer videoId) {
		this.videoId = videoId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public VideoCommentDeleteEvent setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
}
