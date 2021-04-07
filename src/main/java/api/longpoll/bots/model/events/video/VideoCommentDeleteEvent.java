package api.longpoll.bots.model.events.video;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>video_comment_delete</b> event objects.
 */
public class VideoCommentDeleteEvent implements EventObject {
    /**
     * Comment ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Video owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * User ID who deleted the comment.
     */
    @SerializedName("deleter_id")
    private Integer deleterId;

    /**
     * Video ID.
     */
    @SerializedName("video_id")
    private Integer videoId;

    /**
     * ID of the user who deleted a comment.
     */
    @SerializedName("user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getDeleterId() {
        return deleterId;
    }

    public void setDeleterId(Integer deleterId) {
        this.deleterId = deleterId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "VideoCommentDeleteEvent{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", deleterId=" + deleterId +
                ", videoId=" + videoId +
                ", userId=" + userId +
                '}';
    }
}
