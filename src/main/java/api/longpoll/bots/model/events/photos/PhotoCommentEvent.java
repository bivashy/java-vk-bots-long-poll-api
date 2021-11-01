package api.longpoll.bots.model.events.photos;

import api.longpoll.bots.model.objects.basic.WallComment;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>photo_comment_new</b>, <b>photo_comment_edit</b> and <b>photo_comment_restore</b> event objects.
 */
public class PhotoCommentEvent extends WallComment {
    /**
     * Photo ID.
     */
    @SerializedName("photo_id")
    private Integer photoId;

    /**
     * Photo owner ID.
     */
    @SerializedName("photo_owner_id")
    private Integer photoOwnerId;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getPhotoOwnerId() {
        return photoOwnerId;
    }

    public void setPhotoOwnerId(Integer photoOwnerId) {
        this.photoOwnerId = photoOwnerId;
    }


    @Override
    public String toString() {
        return "PhotoCommentEvent{" +
                "photoId=" + photoId +
                ", photoOwnerId=" + photoOwnerId +
                "} " + super.toString();
    }
}
