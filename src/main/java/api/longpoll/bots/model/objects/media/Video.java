package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.objects.additional.Image;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes video.
 *
 * @see <a href="https://vk.com/dev/objects/video">Video</a>
 */
public class Video implements Attachable {
    /**
     * Video ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * ID of the user or community that owns the video.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Video title.
     */
    @SerializedName("title")
    private String title;

    /**
     * Description of the video.
     */
    @SerializedName("description")
    private String description;

    /**
     * Duration of the video, in seconds.
     */
    @SerializedName("duration")
    private Integer duration;

    /**
     * Date (in Unixtime) the video has been uploaded.
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Date (in Unixtime) the video has been added.
     */
    @SerializedName("adding_date")
    private Integer addingDate;

    /**
     * Views count.
     */
    @SerializedName("views")
    private Integer views;

    /**
     * Comments count.
     */
    @SerializedName("comments")
    private Integer commentsAmount;

    /**
     * URL of the page with a player that can be used to play the video in the browser.
     */
    @SerializedName("player")
    private String player;

    /**
     * Platform name.
     */
    @SerializedName("platform")
    private String platform;

    /**
     * <b>true</b> if current user can edit video.
     */
    @SerializedName("can_edit")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canEdit;

    /**
     * <b>true</b> if current user can add video.
     */
    @SerializedName("can_add")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canAdd;

    /**
     * <b>true</b> if video is private.
     */
    @SerializedName("is_private")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean isPrivate;

    /**
     * Access key for an object.
     */
    @SerializedName("access_key")
    private String accessKey;

    /**
     * <b>true</b> if the video is processing.
     */
    @SerializedName("processing")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean processing;

    /**
     * <b>true</b> if the video is live.
     */
    @SerializedName("live")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean live;

    /**
     * <b>true</b> if translation will start soon.
     */
    @SerializedName("upcoming")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean upcoming;

    /**
     * <b>true</b> if object is added to favorites by current users.
     */
    @SerializedName("is_favorite")
    private Boolean isFavourite;

    /**
     * Video preview image.
     */
    @SerializedName("image")
    private List<VideoImage> image;
    @SerializedName("track_code")
    private String trackCode;
    @SerializedName("type")
    private String type;
    @SerializedName("local_views")
    private Integer localViews;

    /**
     * Describes video preview image.
     */
    public static class VideoImage extends Image {
        @SerializedName("with_padding")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean withPadding;

        public Boolean getWithPadding() {
            return withPadding;
        }

        public void setWithPadding(Boolean withPadding) {
            this.withPadding = withPadding;
        }


        @Override
        public String toString() {
            return "VideoImage{" +
                    "withPadding=" + withPadding +
                    "} " + super.toString();
        }
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Integer addingDate) {
        this.addingDate = addingDate;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getCommentsAmount() {
        return commentsAmount;
    }

    public void setCommentsAmount(Integer commentsAmount) {
        this.commentsAmount = commentsAmount;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getCanAdd() {
        return canAdd;
    }

    public void setCanAdd(Boolean canAdd) {
        this.canAdd = canAdd;
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

    public Boolean getProcessing() {
        return processing;
    }

    public void setProcessing(Boolean processing) {
        this.processing = processing;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }

    public List<VideoImage> getImage() {
        return image;
    }

    public void setImage(List<VideoImage> image) {
        this.image = image;
    }

    public String getTrackCode() {
        return trackCode;
    }

    public void setTrackCode(String trackCode) {
        this.trackCode = trackCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLocalViews() {
        return localViews;
    }

    public void setLocalViews(Integer localViews) {
        this.localViews = localViews;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", addingDate=" + addingDate +
                ", views=" + views +
                ", commentsAmount=" + commentsAmount +
                ", player='" + player + '\'' +
                ", platform='" + platform + '\'' +
                ", canEdit=" + canEdit +
                ", canAdd=" + canAdd +
                ", isPrivate=" + isPrivate +
                ", accessKey='" + accessKey + '\'' +
                ", processing=" + processing +
                ", live=" + live +
                ", upcoming=" + upcoming +
                ", isFavourite=" + isFavourite +
                ", image=" + image +
                ", trackCode='" + trackCode + '\'' +
                ", type='" + type + '\'' +
                ", localViews=" + localViews +
                '}';
    }
}
