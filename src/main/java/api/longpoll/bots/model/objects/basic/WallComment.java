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

	public static class Thread {
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

		public void setCount(Integer count) {
			this.count = count;
		}

		public boolean isCanPost() {
			return canPost;
		}

		public void setCanPost(boolean canPost) {
			this.canPost = canPost;
		}

		public boolean isShowReplyButton() {
			return showReplyButton;
		}

		public void setShowReplyButton(boolean showReplyButton) {
			this.showReplyButton = showReplyButton;
		}

		public boolean isGroupsCanPost() {
			return groupsCanPost;
		}

		public void setGroupsCanPost(boolean groupsCanPost) {
			this.groupsCanPost = groupsCanPost;
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

		public void setCount(Integer count) {
			this.count = count;
		}

		public boolean isUserLikes() {
			return userLikes;
		}

		public void setUserLikes(boolean userLikes) {
			this.userLikes = userLikes;
		}

		public boolean isCanLike() {
			return canLike;
		}

		public void setCanLike(boolean canLike) {
			this.canLike = canLike;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
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

	public Integer getReplyToUser() {
		return replyToUser;
	}

	public void setReplyToUser(Integer replyToUser) {
		this.replyToUser = replyToUser;
	}

	public Integer getReplyToComment() {
		return replyToComment;
	}

	public void setReplyToComment(Integer replyToComment) {
		this.replyToComment = replyToComment;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Integer> getParentsStack() {
		return parentsStack;
	}

	public void setParentsStack(List<Integer> parentsStack) {
		this.parentsStack = parentsStack;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}
}
