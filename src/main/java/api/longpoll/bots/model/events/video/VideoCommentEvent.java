package api.longpoll.bots.model.events.video;

import api.longpoll.bots.model.objects.basic.WallComment;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>video_comment_new</b>, <b>video_comment_edit</b> and <b>video_comment_restore</b> event objects.
 */
public class VideoCommentEvent extends WallComment {
    /**
     * Video ID.
     */
    @SerializedName("video_id")
    private Integer videoId;

    /**
     * Video owner ID.
     */
    @SerializedName("video_owner_id")
    private Integer videoOwnerId;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getVideoOwnerId() {
        return videoOwnerId;
    }

    public void setVideoOwnerId(Integer videoOwnerId) {
        this.videoOwnerId = videoOwnerId;
    }


    @Override
    public String toString() {
        return "VideoCommentEvent{" +
                "videoId=" + videoId +
                ", videoOwnerId=" + videoOwnerId +
                "} " + super.toString();
    }
}
