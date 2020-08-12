package bots.longpoll.sdk.model.wall.post;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import bots.longpoll.sdk.model.attachment.Attachment;
import bots.longpoll.sdk.model.attachment.MediaObject;
import bots.longpoll.sdk.model.geo.Geo;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WallPost extends MediaObject {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("from_id")
	private Integer fromId;
	@SerializedName("from")
	private From from;
	@SerializedName("created_by")
	private Integer createdBy;
	@SerializedName("to_id")
	private Integer toId;
	@SerializedName("date")
	private Integer date;
	@SerializedName("text")
	private String text;
	@SerializedName("reply_owner_id")
	private Integer replyOwnerId;
	@SerializedName("reply_post_id")
	private Integer replyPostId;
	@SerializedName("friends_only")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean friendsOnly;
	@SerializedName("comments")
	private Comments comments;
	@SerializedName("copyright")
	private String copyright;
	@SerializedName("likes")
	private WallPostLikes wallPostLikes;
	@SerializedName("reposts")
	private Reposts reposts;
	@SerializedName("views")
	private Views views;
	@SerializedName("post_type")
	private String postType;
	@SerializedName("attachments")
	private List<Attachment> attachments;
	@SerializedName("geo")
	private Geo geo;
	@SerializedName("signer_id")
	private Integer signerId;
	@SerializedName("copy_history")
	private List<WallPost> copyHistory;
	@SerializedName("can_pin")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canPin;
	@SerializedName("can_delete")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canDelete;
	@SerializedName("can_edit")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean canEdit;
	@SerializedName("is_pinned")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean pinned;
	@SerializedName("marked_as_ads")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean markedAsAds;
	@SerializedName("is_favourite")
	private boolean favourite;
	@SerializedName("postponed_id")
	private Integer postponedId;
	@SerializedName("can_archive")
	private boolean canArchive;
	@SerializedName("is_archived")
	private boolean archived;
	@SerializedName("post_source")
	private PostSource postSource;

	public Integer getId() {
		return id;
	}

	public WallPost setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public WallPost setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public From getFrom() {
		return from;
	}

	public WallPost setFrom(From from) {
		this.from = from;
		return this;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public WallPost setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public WallPost setDate(Integer date) {
		this.date = date;
		return this;
	}

	public String getText() {
		return text;
	}

	public WallPost setText(String text) {
		this.text = text;
		return this;
	}

	public Integer getReplyOwnerId() {
		return replyOwnerId;
	}

	public WallPost setReplyOwnerId(Integer replyOwnerId) {
		this.replyOwnerId = replyOwnerId;
		return this;
	}

	public Integer getReplyPostId() {
		return replyPostId;
	}

	public WallPost setReplyPostId(Integer replyPostId) {
		this.replyPostId = replyPostId;
		return this;
	}

	public boolean isFriendsOnly() {
		return friendsOnly;
	}

	public WallPost setFriendsOnly(boolean friendsOnly) {
		this.friendsOnly = friendsOnly;
		return this;
	}

	public Comments getComments() {
		return comments;
	}

	public WallPost setComments(Comments comments) {
		this.comments = comments;
		return this;
	}

	public String getCopyright() {
		return copyright;
	}

	public WallPost setCopyright(String copyright) {
		this.copyright = copyright;
		return this;
	}

	public WallPostLikes getWallPostLikes() {
		return wallPostLikes;
	}

	public WallPost setWallPostLikes(WallPostLikes wallPostLikes) {
		this.wallPostLikes = wallPostLikes;
		return this;
	}

	public Reposts getReposts() {
		return reposts;
	}

	public WallPost setReposts(Reposts reposts) {
		this.reposts = reposts;
		return this;
	}

	public Views getViews() {
		return views;
	}

	public WallPost setViews(Views views) {
		this.views = views;
		return this;
	}

	public String getPostType() {
		return postType;
	}

	public WallPost setPostType(String postType) {
		this.postType = postType;
		return this;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public WallPost setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
		return this;
	}

	public Geo getGeo() {
		return geo;
	}

	public WallPost setGeo(Geo geo) {
		this.geo = geo;
		return this;
	}

	public Integer getSignerId() {
		return signerId;
	}

	public WallPost setSignerId(Integer signerId) {
		this.signerId = signerId;
		return this;
	}

	public List<WallPost> getCopyHistory() {
		return copyHistory;
	}

	public WallPost setCopyHistory(List<WallPost> copyHistory) {
		this.copyHistory = copyHistory;
		return this;
	}

	public boolean isCanPin() {
		return canPin;
	}

	public WallPost setCanPin(boolean canPin) {
		this.canPin = canPin;
		return this;
	}

	public boolean isCanDelete() {
		return canDelete;
	}

	public WallPost setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
		return this;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public WallPost setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
		return this;
	}

	public boolean isPinned() {
		return pinned;
	}

	public WallPost setPinned(boolean pinned) {
		this.pinned = pinned;
		return this;
	}

	public boolean isMarkedAsAds() {
		return markedAsAds;
	}

	public WallPost setMarkedAsAds(boolean markedAsAds) {
		this.markedAsAds = markedAsAds;
		return this;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public WallPost setFavourite(boolean favourite) {
		this.favourite = favourite;
		return this;
	}

	public Integer getPostponedId() {
		return postponedId;
	}

	public WallPost setPostponedId(Integer postponedId) {
		this.postponedId = postponedId;
		return this;
	}

	public Integer getToId() {
		return toId;
	}

	public WallPost setToId(Integer toId) {
		this.toId = toId;
		return this;
	}

	public Integer getFromId() {
		return fromId;
	}

	public WallPost setFromId(Integer fromId) {
		this.fromId = fromId;
		return this;
	}

	public boolean isCanArchive() {
		return canArchive;
	}

	public WallPost setCanArchive(boolean canArchive) {
		this.canArchive = canArchive;
		return this;
	}

	public boolean isArchived() {
		return archived;
	}

	public WallPost setArchived(boolean archived) {
		this.archived = archived;
		return this;
	}

	public PostSource getPostSource() {
		return postSource;
	}

	public WallPost setPostSource(PostSource postSource) {
		this.postSource = postSource;
		return this;
	}
}
