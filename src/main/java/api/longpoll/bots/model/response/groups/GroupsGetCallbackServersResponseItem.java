package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getCallbackServers</b> request.
 */
public class GroupsGetCallbackServersResponseItem {
    /**
     * Server ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Server title.
     */
    @SerializedName("title")
    private String title;

    /**
     * ID of the user who had added the server.
     */
    @SerializedName("creator_id")
    private Integer creatorId;

    /**
     * Server URL.
     */
    @SerializedName("url")
    private String url;

    /**
     * Server secret key.
     */
    @SerializedName("secret_key")
    private String secretKey;

    /**
     * Server status.
     */
    @SerializedName("status")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GroupsGetCallbackServersResponseItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creatorId=" + creatorId +
                ", url='" + url + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
