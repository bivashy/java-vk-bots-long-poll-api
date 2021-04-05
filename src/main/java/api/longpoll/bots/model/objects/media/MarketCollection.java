package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

/**
 * Describes market collection.
 *
 * @see <a href="https://vk.com/dev/objects/market_album">Market Collection</a>
 */
public class MarketCollection implements Attachable {
    /**
     * Collection ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Collection owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Collection title.
     */
    @SerializedName("title")
    private String title;

    /**
     * Collection cover photo object.
     */
    @SerializedName("photo")
    private Photo photo;

    /**
     * Items number.
     */
    @SerializedName("count")
    private Integer count;

    /**
     * Last update date in Unixtime.
     */
    @SerializedName("updated_time")
    private Integer updatedTime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Integer updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "MarketCollection{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", title='" + title + '\'' +
                ", photo=" + photo +
                ", count=" + count +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
