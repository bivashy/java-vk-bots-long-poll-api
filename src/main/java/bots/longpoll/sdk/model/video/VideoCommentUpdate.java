package bots.longpoll.sdk.model.video;

import bots.longpoll.sdk.model.wall.reply.WallReply;
import com.google.gson.annotations.SerializedName;

public class VideoCommentUpdate extends WallReply {
	@SerializedName("video_id")
	private Integer videoId;
	@SerializedName("video_owner_id")
	private Integer videoOwnerId;

	public Integer getVideoId() {
		return videoId;
	}

	public VideoCommentUpdate setVideoId(Integer videoId) {
		this.videoId = videoId;
		return this;
	}

	public Integer getVideoOwnerId() {
		return videoOwnerId;
	}

	public VideoCommentUpdate setVideoOwnerId(Integer videoOwnerId) {
		this.videoOwnerId = videoOwnerId;
		return this;
	}
}
