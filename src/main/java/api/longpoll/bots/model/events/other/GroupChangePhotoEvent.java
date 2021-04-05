package api.longpoll.bots.model.events.other;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.media.Photo;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>group_change_photo</b> event objects.
 */
public class GroupChangePhotoEvent implements EventObject {
    /**
     * ID of the user who made changes.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * Photo object.
     */
    @SerializedName("photo")
    private Photo photo;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "GroupChangePhotoEvent{" +
                "userId=" + userId +
                ", photo=" + photo +
                '}';
    }
}
