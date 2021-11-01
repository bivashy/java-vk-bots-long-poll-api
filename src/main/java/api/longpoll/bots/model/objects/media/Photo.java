package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes photo.
 *
 * @see <a href="https://vk.com/dev/objects/photo">Photo</a>
 */
public class Photo implements Attachable {
    /**
     * Photo ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Photo album ID.
     */
    @SerializedName("album_id")
    private Integer albumId;

    /**
     * Photo owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * ID of the user who uploaded the photo (if the photo is uploaded in community). 100 for photos uploaded by the community.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * Description text.
     */
    @SerializedName("text")
    private String text;

    /**
     * Date when the photo has been added in Unixtime.
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Array with the photo copies of different photoSizes.
     */
    @SerializedName("sizes")
    private List<PhotoSize> photoSizes;

    /**
     * Photo access key.
     */
    @SerializedName("access_key")
    private String accessKey;

    public boolean hasText() {
        return text != null && !text.isEmpty();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public List<PhotoSize> getPhotoSizes() {
        return photoSizes;
    }

    public void setPhotoSizes(List<PhotoSize> photoSizes) {
        this.photoSizes = photoSizes;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", ownerId=" + ownerId +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", photoSizes=" + photoSizes +
                ", accessKey='" + accessKey + '\'' +
                '}';
    }
}
