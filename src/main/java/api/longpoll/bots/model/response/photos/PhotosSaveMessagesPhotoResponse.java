package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>photos.saveMessagesPhoto</b> request.
 */
public class PhotosSaveMessagesPhotoResponse {
    /**
     * Album ID.
     */
    @SerializedName("album_id")
    private Integer albumId;

    /**
     * Saved date.
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Photo ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Photo owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * <b>true</b> if photo has tags.
     */
    @SerializedName("has_tags")
    private Boolean hasTags;

    /**
     * Access key.
     */
    @SerializedName("access_key")
    private String accessKey;

    /**
     * Photo copies.
     */
    @SerializedName("photoSizes")
    private List<PhotoSize> photoSizes;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

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

    public Boolean getHasTags() {
        return hasTags;
    }

    public void setHasTags(Boolean hasTags) {
        this.hasTags = hasTags;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public List<PhotoSize> getPhotoSizes() {
        return photoSizes;
    }

    public void setPhotoSizes(List<PhotoSize> photoSizes) {
        this.photoSizes = photoSizes;
    }

    @Override
    public String toString() {
        return "PhotosSaveMessagesPhotoResponse{" +
                "albumId=" + albumId +
                ", date=" + date +
                ", id=" + id +
                ", ownerId=" + ownerId +
                ", hasTags=" + hasTags +
                ", accessKey='" + accessKey + '\'' +
                ", photoSizes=" + photoSizes +
                '}';
    }
}
