package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

/**
 * Describes graffiti.
 */
public class Graffiti implements Attachable {
    /**
     * Graffiti ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Graffiti owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Graffiti url.
     */
    @SerializedName("url")
    private String url;

    /**
     * Graffiti width in px.
     */
    @SerializedName("width")
    private Integer width;

    /**
     * Graffiti height in px.
     */
    @SerializedName("height")
    private Integer height;

    /**
     * Graffiti access key.
     */
    @SerializedName("access_key")
    private String accessKey;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public String toString() {
        return "Graffiti{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", accessKey='" + accessKey + '\'' +
                '}';
    }
}
