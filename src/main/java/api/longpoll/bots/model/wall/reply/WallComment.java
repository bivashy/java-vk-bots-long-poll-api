package api.longpoll.bots.model.wall.reply;

import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.Attachment;
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
	private WallReplyLikes likes;

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

	public WallReplyLikes getLikes() {
		return likes;
	}

	public WallComment setLikes(WallReplyLikes likes) {
		this.likes = likes;
		return this;
	}
}
