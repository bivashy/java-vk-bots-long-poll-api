package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.additional.Geo;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WallPost implements Attachable {
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
	private Likes likes;
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

	public static class Comments {
		@SerializedName("count")
		private Integer count;
		@SerializedName("can_post")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean canPost;
		@SerializedName("groups_can_post")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean groupsCanPost;
		@SerializedName("can_close")
		private boolean canClose;
		@SerializedName("can_open")
		private boolean canOpen;

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public boolean isCanPost() {
			return canPost;
		}

		public void setCanPost(boolean canPost) {
			this.canPost = canPost;
		}

		public boolean isGroupsCanPost() {
			return groupsCanPost;
		}

		public void setGroupsCanPost(boolean groupsCanPost) {
			this.groupsCanPost = groupsCanPost;
		}

		public boolean isCanClose() {
			return canClose;
		}

		public void setCanClose(boolean canClose) {
			this.canClose = canClose;
		}

		public boolean isCanOpen() {
			return canOpen;
		}

		public void setCanOpen(boolean canOpen) {
			this.canOpen = canOpen;
		}
	}

	public static class From {
		@SerializedName("id")
		private Integer id;
		@SerializedName("name")
		private String name;
		@SerializedName("is_closed")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean closed;
		@SerializedName("type")
		private String type;
		@SerializedName("photo_50")
		private String photo50;
		@SerializedName("photo_100")
		private String photo100;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isClosed() {
			return closed;
		}

		public void setClosed(boolean closed) {
			this.closed = closed;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getPhoto50() {
			return photo50;
		}

		public void setPhoto50(String photo50) {
			this.photo50 = photo50;
		}

		public String getPhoto100() {
			return photo100;
		}

		public void setPhoto100(String photo100) {
			this.photo100 = photo100;
		}
	}

	public static class Likes extends WallComment.Likes {
		@SerializedName("can_publish")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean canPublish;

		public boolean isCanPublish() {
			return canPublish;
		}

		public void setCanPublish(boolean canPublish) {
			this.canPublish = canPublish;
		}
	}

	public static class Reposts {
		@SerializedName("count")
		private Integer count;
		@SerializedName("user_reposted")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean userReposted;

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public boolean isUserReposted() {
			return userReposted;
		}

		public void setUserReposted(boolean userReposted) {
			this.userReposted = userReposted;
		}
	}

	public static class Views {
		@SerializedName("count")
		private Integer count;

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}
	}

	public static class PostSource {
		@SerializedName("type")
		private String type;
		@SerializedName("platform")
		private String platform;
		@SerializedName("data")
		private String data;
		@SerializedName("url")
		private String url;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getPlatform() {
			return platform;
		}

		public void setPlatform(String platform) {
			this.platform = platform;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
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

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public From getFrom() {
		return from;
	}

	public void setFrom(From from) {
		this.from = from;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getReplyOwnerId() {
		return replyOwnerId;
	}

	public void setReplyOwnerId(Integer replyOwnerId) {
		this.replyOwnerId = replyOwnerId;
	}

	public Integer getReplyPostId() {
		return replyPostId;
	}

	public void setReplyPostId(Integer replyPostId) {
		this.replyPostId = replyPostId;
	}

	public boolean isFriendsOnly() {
		return friendsOnly;
	}

	public void setFriendsOnly(boolean friendsOnly) {
		this.friendsOnly = friendsOnly;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}

	public Reposts getReposts() {
		return reposts;
	}

	public void setReposts(Reposts reposts) {
		this.reposts = reposts;
	}

	public Views getViews() {
		return views;
	}

	public void setViews(Views views) {
		this.views = views;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	public Integer getSignerId() {
		return signerId;
	}

	public void setSignerId(Integer signerId) {
		this.signerId = signerId;
	}

	public List<WallPost> getCopyHistory() {
		return copyHistory;
	}

	public void setCopyHistory(List<WallPost> copyHistory) {
		this.copyHistory = copyHistory;
	}

	public boolean isCanPin() {
		return canPin;
	}

	public void setCanPin(boolean canPin) {
		this.canPin = canPin;
	}

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	public boolean isMarkedAsAds() {
		return markedAsAds;
	}

	public void setMarkedAsAds(boolean markedAsAds) {
		this.markedAsAds = markedAsAds;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	public Integer getPostponedId() {
		return postponedId;
	}

	public void setPostponedId(Integer postponedId) {
		this.postponedId = postponedId;
	}

	public boolean isCanArchive() {
		return canArchive;
	}

	public void setCanArchive(boolean canArchive) {
		this.canArchive = canArchive;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public PostSource getPostSource() {
		return postSource;
	}

	public void setPostSource(PostSource postSource) {
		this.postSource = postSource;
	}
}
