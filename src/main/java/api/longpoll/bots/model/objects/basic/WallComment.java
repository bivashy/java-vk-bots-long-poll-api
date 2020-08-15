package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WallComment implements Attachable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("from_id")
	private Integer fromId;
	@SerializedName("date")
	private Integer date;
	@SerializedName("text")
	private String text;
	@SerializedName("reply_to_user")
	private Integer replyToUser;
	@SerializedName("reply_to_comment")
	private Integer replyToComment;
	@SerializedName("attachments")
	private List<Attachment> attachments;
	@SerializedName("parents_stack")
	private List<Integer> parentsStack;
	@SerializedName("thread")
	private Thread thread;
	@SerializedName("post_id")
	private Integer postId;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("likes")
	private Likes likes;

	public class Thread {
		@SerializedName("count")
		private Integer count;
		@SerializedName("can_post")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean canPost;
		@SerializedName("show_reply_button")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean showReplyButton;
		@SerializedName("groups_can_post")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean groupsCanPost;

		public Integer getCount() {
			return count;
		}

		public Thread setCount(Integer count) {
			this.count = count;
			return this;
		}

		public boolean isCanPost() {
			return canPost;
		}

		public Thread setCanPost(boolean canPost) {
			this.canPost = canPost;
			return this;
		}

		public boolean isShowReplyButton() {
			return showReplyButton;
		}

		public Thread setShowReplyButton(boolean showReplyButton) {
			this.showReplyButton = showReplyButton;
			return this;
		}

		public boolean isGroupsCanPost() {
			return groupsCanPost;
		}

		public Thread setGroupsCanPost(boolean groupsCanPost) {
			this.groupsCanPost = groupsCanPost;
			return this;
		}
	}

	public static class Likes {
		@SerializedName("count")
		private Integer count;
		@SerializedName("user_likes")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean userLikes;
		@SerializedName("can_like")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean canLike;

		public Integer getCount() {
			return count;
		}

		public Likes setCount(Integer count) {
			this.count = count;
			return this;
		}

		public boolean isUserLikes() {
			return userLikes;
		}

		public Likes setUserLikes(boolean userLikes) {
			this.userLikes = userLikes;
			return this;
		}

		public boolean isCanLike() {
			return canLike;
		}

		public Likes setCanLike(boolean canLike) {
			this.canLike = canLike;
			return this;
		}
	}

	public boolean hasText() {
		return text != null && !text.isEmpty();
	}

	private boolean hasReplyToUser() {
		return replyToUser != null;
	}

	private boolean hasReplyToComment() {
		return replyToComment != null;
	}

	private boolean hasAttachments() {
		return attachments != null && !attachments.isEmpty();
	}

	private boolean hasParentsStack() {
		return parentsStack != null && !parentsStack.isEmpty();
	}

	private boolean hasThread() {
		return thread != null;
	}

	public Integer getId() {
		return id;
	}

	public WallComment setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getFromId() {
		return fromId;
	}

	public WallComment setFromId(Integer fromId) {
		this.fromId = fromId;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public WallComment setDate(Integer date) {
		this.date = date;
		return this;
	}

	public String getText() {
		return text;
	}

	public WallComment setText(String text) {
		this.text = text;
		return this;
	}

	public Integer getReplyToUser() {
		return replyToUser;
	}

	public WallComment setReplyToUser(Integer replyToUser) {
		this.replyToUser = replyToUser;
		return this;
	}

	public Integer getReplyToComment() {
		return replyToComment;
	}

	public WallComment setReplyToComment(Integer replyToComment) {
		this.replyToComment = replyToComment;
		return this;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public WallComment setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
		return this;
	}

	public List<Integer> getParentsStack() {
		return parentsStack;
	}

	public WallComment setParentsStack(List<Integer> parentsStack) {
		this.parentsStack = parentsStack;
		return this;
	}

	public Thread getThread() {
		return thread;
	}

	public WallComment setThread(Thread thread) {
		this.thread = thread;
		return this;
	}

	public Integer getPostId() {
		return postId;
	}

	public WallComment setPostId(Integer postId) {
		this.postId = postId;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public WallComment setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Likes getLikes() {
		return likes;
	}

	public WallComment setLikes(Likes likes) {
		this.likes = likes;
		return this;
	}
}
