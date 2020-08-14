package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes topic comment.
 * @see <a href="https://vk.com/dev/objects/comment_board">Topic Comment</a>
 */
public class TopicComment implements EventObject {
	/**
	 * Comment ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * Comment author ID.
	 */
	@SerializedName("from_id")
	private Integer fromId;

	/**
	 * Date when the comment has been added in Unixtime.
	 */
	@SerializedName("date")
	private Integer date;

	/**
	 * Comment text.
	 */
	@SerializedName("text")
	private String text;

	/**
	 * Information about attachments in the comments (photos, links, etc).
	 */
	@SerializedName("attachments")
	private List<Attachment> attachments;

	/**
	 * Information about likes.
	 */
	@SerializedName("likes")
	private Likes likes;

	/**
	 * Describes topic comment likes.
	 */
	public class Likes {
		/**
		 * Likes count.
		 */
		@SerializedName("count")
		private Integer count;

		/**
		 * <b>true</b> if current user likes the comment.
		 */
		@SerializedName("user_likes")
		@JsonAdapter(BoolIntAdapter.class)
		private Boolean userLikes;

		/**
		 * <b>true</b> if current user can like the comment.
		 */
		@SerializedName("can_like")
		@JsonAdapter(BoolIntAdapter.class)
		private Boolean canLike;

		public Integer getCount() {
			return count;
		}

		public Likes setCount(Integer count) {
			this.count = count;
			return this;
		}

		public Boolean getUserLikes() {
			return userLikes;
		}

		public Likes setUserLikes(Boolean userLikes) {
			this.userLikes = userLikes;
			return this;
		}

		public Boolean getCanLike() {
			return canLike;
		}

		public Likes setCanLike(Boolean canLike) {
			this.canLike = canLike;
			return this;
		}
	}

	public Integer getId() {
		return id;
	}

	public TopicComment setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getFromId() {
		return fromId;
	}

	public TopicComment setFromId(Integer fromId) {
		this.fromId = fromId;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public TopicComment setDate(Integer date) {
		this.date = date;
		return this;
	}

	public String getText() {
		return text;
	}

	public TopicComment setText(String text) {
		this.text = text;
		return this;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public TopicComment setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
		return this;
	}

	public Likes getLikes() {
		return likes;
	}

	public TopicComment setLikes(Likes likes) {
		this.likes = likes;
		return this;
	}
}
