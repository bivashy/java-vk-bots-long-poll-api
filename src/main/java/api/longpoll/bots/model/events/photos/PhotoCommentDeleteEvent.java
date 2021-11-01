package api.longpoll.bots.model.events.photos;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>photo_comment_delete</b> event objects.
 */
public class PhotoCommentDeleteEvent implements EventObject {
    /**
     * Photo owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Comment ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * ID of the user who deleted a comment.
     */
    @SerializedName("deleter_id")
    private Integer deleterId;

    /**
     * Photo ID.
     */
    @SerializedName("photo_id")
    private Integer photoId;

    /**
     * Comment author ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeleterId() {
        return deleterId;
    }

    public void setDeleterId(Integer deleterId) {
        this.deleterId = deleterId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PhotoCommentDeleteEvent{" +
                "ownerId=" + ownerId +
                ", id=" + id +
                ", deleterId=" + deleterId +
                ", photoId=" + photoId +
                ", userId=" + userId +
                '}';
    }
}
