package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.media.Video;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Describes story.
 *
 * @see <a href="https://vk.com/dev/objects/story">Story</a>
 */
public class Story {
    /**
     * Story ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Story owner's ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Date when story has been added in Unixtime.
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Whether current user has seen the story or not.
     */
    @SerializedName("seen")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean seen;

    /**
     * Story type. Possible values:
     * <ul>
     *     <li>photo</li>
     *     <li>video</li>
     * </ul>
     */
    @SerializedName("type")
    private String type;

    /**
     * Photo from the story.
     */
    @SerializedName("photo")
    private Photo photo;

    /**
     * Video from the story.
     */
    @SerializedName("video")
    private Video video;

    /**
     * Whether current user can share the story.
     */
    @SerializedName("can_share")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canShare;

    /**
     * Whether current user can comment the story.
     */
    @SerializedName("can_comment")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canComment;

    /**
     * Views number.
     */
    @SerializedName("views")
    private Integer views;

    /**
     * Whether the story is private.
     */
    @SerializedName("is_private")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean isPrivate;

    /**
     * Access key for private object.
     */
    @SerializedName("access_key")
    private String accessKey;

    /**
     * Whether the story has been expired.
     */
    @SerializedName("expired")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean expired;

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

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Boolean getCanShare() {
        return canShare;
    }

    public void setCanShare(Boolean canShare) {
        this.canShare = canShare;
    }

    public Boolean getCanComment() {
        return canComment;
    }

    public void setCanComment(Boolean canComment) {
        this.canComment = canComment;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", date=" + date +
                ", seen=" + seen +
                ", type='" + type + '\'' +
                ", photo=" + photo +
                ", video=" + video +
                ", canShare=" + canShare +
                ", canComment=" + canComment +
                ", views=" + views +
                ", isPrivate=" + isPrivate +
                ", accessKey='" + accessKey + '\'' +
                ", expired=" + expired +
                '}';
    }
}
