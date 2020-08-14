package api.longpoll.bots.model.video;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.objects.media.Attachable;
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

	public Integer getId() {
		return id;
	}

	public Video setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Video setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Video setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Video setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getDuration() {
		return duration;
	}

	public Video setDuration(Integer duration) {
		this.duration = duration;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public Video setDate(Integer date) {
		this.date = date;
		return this;
	}

	public Integer getAddingDate() {
		return addingDate;
	}

	public Video setAddingDate(Integer addingDate) {
		this.addingDate = addingDate;
		return this;
	}

	public Integer getViews() {
		return views;
	}

	public Video setViews(Integer views) {
		this.views = views;
		return this;
	}

	public Integer getCommentsAmount() {
		return commentsAmount;
	}

	public Video setCommentsAmount(Integer commentsAmount) {
		this.commentsAmount = commentsAmount;
		return this;
	}

	public String getPlayer() {
		return player;
	}

	public Video setPlayer(String player) {
		this.player = player;
		return this;
	}

	public String getPlatform() {
		return platform;
	}

	public Video setPlatform(String platform) {
		this.platform = platform;
		return this;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public Video setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
		return this;
	}

	public boolean isCanAdd() {
		return canAdd;
	}

	public Video setCanAdd(boolean canAdd) {
		this.canAdd = canAdd;
		return this;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public Video setPrivate(boolean aPrivate) {
		isPrivate = aPrivate;
		return this;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public Video setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}

	public boolean isProcessing() {
		return processing;
	}

	public Video setProcessing(boolean processing) {
		this.processing = processing;
		return this;
	}

	public boolean isLive() {
		return live;
	}

	public Video setLive(boolean live) {
		this.live = live;
		return this;
	}

	public boolean isUpcoming() {
		return upcoming;
	}

	public Video setUpcoming(boolean upcoming) {
		this.upcoming = upcoming;
		return this;
	}

	public boolean isFavourite() {
		return isFavourite;
	}

	public Video setFavourite(boolean favourite) {
		isFavourite = favourite;
		return this;
	}

	public List<VideoImage> getImage() {
		return image;
	}

	public Video setImage(List<VideoImage> image) {
		this.image = image;
		return this;
	}

	public String getTrackCode() {
		return trackCode;
	}

	public Video setTrackCode(String trackCode) {
		this.trackCode = trackCode;
		return this;
	}

	public String getType() {
		return type;
	}

	public Video setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getLocalViews() {
		return localViews;
	}

	public Video setLocalViews(Integer localViews) {
		this.localViews = localViews;
		return this;
	}
}
