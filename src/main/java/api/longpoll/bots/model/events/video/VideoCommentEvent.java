package api.longpoll.bots.model.events.video;

import api.longpoll.bots.model.objects.basic.WallComment;
import com.google.gson.annotations.SerializedName;

public class VideoCommentEvent extends WallComment {
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
