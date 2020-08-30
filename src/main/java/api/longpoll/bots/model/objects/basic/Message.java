package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.additional.Geo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Message object.
 *
 * @see <a href="https://vk.com/dev/objects/message">Private Message</a>
 */
public class Message implements EventObject {
	/**
	 * Message ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * Date (in Unixtime) when the messages was sent.
	 */
	@SerializedName("date")
	private Integer date;

	/**
	 * Destination ID.
	 * If the messages was sent to dialog, then peerId = fromId, and peerId = Chat Id otherwise
	 */
	@SerializedName("peer_id")
	private Integer peerId;

	/**
	 * User ID - the author of the messages.
	 */
	@SerializedName("from_id")
	private Integer fromId;

	/**
	 * Message text.
	 */
	@SerializedName("text")
	private String text;

	/**
	 * Parameter used while sending the messages to avoid double sending.
	 */
	@SerializedName("random_id")
	private Integer randomId;

	/**
	 * List of media-attachments.
	 */
	@SerializedName("attachments")
	private List<Attachment> attachments;

	/**
	 * true, whether the messages is marked as important.
	 */
	@SerializedName("important")
	private Boolean important;

	/**
	 * Information about location.
	 */
	@SerializedName("geo")
	private Geo geo;

	/**
	 * Service field (payload).
	 */
	@SerializedName("payload")
	private String payload;

	/**
	 * List of forwarded messages (if any).
	 */
	@SerializedName("fwd_messages")
	private List<Message> fwdMessages;

	/**
	 * Reply messages object.
	 */
	@SerializedName("reply_message")
	private Message replyMessage;

	/**
	 * Information about service action with conversation
	 */
	@SerializedName("action")
	private Action action;

	/**
	 * Conversation message ID.
	 */
	@SerializedName("conversation_message_id")
	private Integer conversationMessageId;

	/**
	 * Contains information about service action with conversation.
	 */
	public static class Action {
		/**
		 * Action type. Possible values:
		 * <ul>
		 * <li><i>chat_photo_update</i> — conversation photo updated;</li>
		 * <li><i>chat_photo_remove</i> — conversation photo deleted;</li>
		 * <li><i>chat_create</i> — conversation created;</li>
		 * <li><i>chat_title_update</i> — conversation title updated;</li>
		 * <li><i>chat_invite_user</i> — user invited;</li>
		 * <li><i>chat_kick_user</i> — user kicked;</li>
		 * <li><i>chat_pin_message</i> — message pinned;</li>
		 * <li><i>chat_unpin_message</i> — message unpinned;</li>
		 * <li><i>chat_invite_user_by_link</i> — user joined the conversation by link.</li>
		 * </ul>
		 */
		@SerializedName("type")
		private String type;

		/**
		 * User ID (positive) or email (negative) has been invited or kicked (for service messages with <b>type</b> = chat_invite_user, chat_invite_user_by_link or chat_kick_user). user ID, who pinned/unpinned message (<b>action</b> = chat_pin_message or chat_unpin_message).
		 */
		@SerializedName("member_id")
		private Integer memberId;

		/**
		 * Conversation title (for service messages with type = chat_create or chat_title_update).
		 */
		@SerializedName("text")
		private String text;

		/**
		 * Email has been invited or kicked (for service messages with <b>type</b> = chat_invite_user or chat_kick_user and negative <b>member_id</b>).
		 */
		@SerializedName("email")
		private String email;

		/**
		 * Conversation cover image.
		 */
		@SerializedName("photo")
		private Photo photo;

		/**
		 * Contains conversation cover image.
		 */
		public static class Photo {
			/**
			 * URL of conversation image with width size of 50 px.
			 */
			@SerializedName("photo_50")
			private String photo50;

			/**
			 * URL of conversation image with width size of 100 px.
			 */
			@SerializedName("photo_100")
			private String photo100;

			/**
			 * URL of conversation image with width size of 200 px.
			 */
			@SerializedName("photo_200")
			private String photo200;

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

			public String getPhoto200() {
				return photo200;
			}

			public void setPhoto200(String photo200) {
				this.photo200 = photo200;
			}
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getMemberId() {
			return memberId;
		}

		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Photo getPhoto() {
			return photo;
		}

		public void setPhoto(Photo photo) {
			this.photo = photo;
		}
	}

	public Boolean hasText() {
		return text != null && !text.isEmpty();
	}

	public Boolean hasAttachments() {
		return attachments != null && !attachments.isEmpty();
	}

	public Boolean hasGeo() {
		return geo != null;
	}

	public Boolean hasFwdMessages() {
		return fwdMessages != null && !fwdMessages.isEmpty();
	}

	public Boolean hasReplyMessage() {
		return replyMessage != null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Integer getPeerId() {
		return peerId;
	}

	public void setPeerId(Integer peerId) {
		this.peerId = peerId;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getRandomId() {
		return randomId;
	}

	public void setRandomId(Integer randomId) {
		this.randomId = randomId;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Boolean getImportant() {
		return important;
	}

	public void setImportant(Boolean important) {
		this.important = important;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public List<Message> getFwdMessages() {
		return fwdMessages;
	}

	public void setFwdMessages(List<Message> fwdMessages) {
		this.fwdMessages = fwdMessages;
	}

	public Message getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(Message replyMessage) {
		this.replyMessage = replyMessage;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Integer getConversationMessageId() {
		return conversationMessageId;
	}

	public void setConversationMessageId(Integer conversationMessageId) {
		this.conversationMessageId = conversationMessageId;
	}
}
