package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.objects.additional.Image;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Video implements Attachable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("title")
	private String title;
	@SerializedName("description")
	private String description;
	@SerializedName("duration")
	private Integer duration;
	@SerializedName("date")
	private Integer date;
	@SerializedName("adding_date")
	private Integer addingDate;
	@SerializedName("views")
	private Integer views;
	@SerializedName("comments")
	private Integer commentsAmount;
	@SerializedName("player")
	private String player;
	@SerializedName("platform")
	private String platform;
	@SerializedName("can_edit")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canEdit;
	@SerializedName("can_add")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canAdd;
	@SerializedName("is_private")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean isPrivate;
	@SerializedName("access_key")
	private String accessKey;
	@SerializedName("processing")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean processing;
	@SerializedName("live")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean live;
	@SerializedName("upcoming")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean upcoming;
	@SerializedName("is_favorite")
	private boolean isFavourite;
	@SerializedName("image")
	private List<VideoImage> image;
	@SerializedName("track_code")
	private String trackCode;
	@SerializedName("type")
	private String type;
	@SerializedName("local_views")
	private Integer localViews;

	public static class VideoImage extends Image {
		@SerializedName("with_padding")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean withPadding;

		public boolean isWithPadding() {
			return withPadding;
		}

		public void setWithPadding(boolean withPadding) {
			this.withPadding = withPadding;
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

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	public boolean isCanAdd() {
		return canAdd;
	}

	public void setCanAdd(boolean canAdd) {
		this.canAdd = canAdd;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean aPrivate) {
		isPrivate = aPrivate;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public boolean isProcessing() {
		return processing;
	}

	public void setProcessing(boolean processing) {
		this.processing = processing;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isUpcoming() {
		return upcoming;
	}

	public void setUpcoming(boolean upcoming) {
		this.upcoming = upcoming;
	}

	public boolean isFavourite() {
		return isFavourite;
	}

	public void setFavourite(boolean favourite) {
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
}
