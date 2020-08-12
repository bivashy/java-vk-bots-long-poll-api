package api.longpoll.bots.model.video;

import api.longpoll.bots.model.wall.reply.WallReply;
import com.google.gson.annotations.SerializedName;

public class VideoCommentEvent extends WallReply {
	@SerializedName("video_id")
	private Integer videoId;
	@SerializedName("video_owner_id")
	private Integer videoOwnerId;

	public Integer getVideoId() {
		return videoId;
	}

	public VideoCommentEvent setVideoId(Integer videoId) {
		this.videoId = videoId;
		return this;
	}

	public Integer getVideoOwnerId() {
		return videoOwnerId;
	}

	public VideoCommentEvent setVideoOwnerId(Integer videoOwnerId) {
		this.videoOwnerId = videoOwnerId;
		return this;
	}
}
