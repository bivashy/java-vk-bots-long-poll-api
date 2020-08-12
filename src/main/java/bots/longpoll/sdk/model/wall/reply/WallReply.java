package bots.longpoll.sdk.model.wall.reply;

import bots.longpoll.sdk.model.attachment.Attachment;
import bots.longpoll.sdk.model.attachment.MediaObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WallReply extends MediaObject {
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

	public WallReply setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getFromId() {
		return fromId;
	}

	public WallReply setFromId(Integer fromId) {
		this.fromId = fromId;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public WallReply setDate(Integer date) {
		this.date = date;
		return this;
	}

	public String getText() {
		return text;
	}

	public WallReply setText(String text) {
		this.text = text;
		return this;
	}

	public Integer getReplyToUser() {
		return replyToUser;
	}

	public WallReply setReplyToUser(Integer replyToUser) {
		this.replyToUser = replyToUser;
		return this;
	}

	public Integer getReplyToComment() {
		return replyToComment;
	}

	public WallReply setReplyToComment(Integer replyToComment) {
		this.replyToComment = replyToComment;
		return this;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public WallReply setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
		return this;
	}

	public List<Integer> getParentsStack() {
		return parentsStack;
	}

	public WallReply setParentsStack(List<Integer> parentsStack) {
		this.parentsStack = parentsStack;
		return this;
	}

	public Thread getThread() {
		return thread;
	}

	public WallReply setThread(Thread thread) {
		this.thread = thread;
		return this;
	}

	public Integer getPostId() {
		return postId;
	}

	public WallReply setPostId(Integer postId) {
		this.postId = postId;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public WallReply setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public WallReplyLikes getLikes() {
		return likes;
	}

	public WallReply setLikes(WallReplyLikes likes) {
		this.likes = likes;
		return this;
	}
}
