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
	private boolean important;

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

	// TODO: 12.08.2020 find out javadoc
	@SerializedName("hidden")
	private boolean hidden;

	/**
	 * Information about service action with conversation
	 */
	@SerializedName("action")
	private Action action;

	// TODO: 12.08.2020 find out javadoc
	@SerializedName("conversation_message_id")
	private Integer conversationMessageId;

	/**
	 * Contains information about service action with conversation.
	 */
	public class Action {
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
		 * Gets action type.
		 *
		 * @return action type.
		 */
		public String getType() {
			return type;
		}

		/**
		 * Sets action type.
		 *
		 * @param type action type.
		 * @return this Action.
		 */
		public Action setType(String type) {
			this.type = type;
			return this;
		}

		/**
		 * Gets user ID.
		 *
		 * @return user ID.
		 */
		public Integer getMemberId() {
			return memberId;
		}

		/**
		 * Sets user ID.
		 *
		 * @param memberId user ID.
		 * @return this Action.
		 */
		public Action setMemberId(Integer memberId) {
			this.memberId = memberId;
			return this;
		}

		/**
		 * Gets conversation title.
		 *
		 * @return conversation title.
		 */
		public String getText() {
			return text;
		}

		/**
		 * Sets conversation title.
		 *
		 * @param text conversation title.
		 * @return this Action.
		 */
		public Action setText(String text) {
			this.text = text;
			return this;
		}

		/**
		 * Gets email.
		 *
		 * @return email.
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * Sets email.
		 *
		 * @param email email.
		 * @return this Action.
		 */
		public Action setEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * Gets conversation cover image.
		 *
		 * @return conversation cover image.
		 */
		public Photo getPhoto() {
			return photo;
		}

		/**
		 * Sets conversation cover image.
		 *
		 * @param photo conversation cover image.
		 * @return this Action.
		 */
		public Action setPhoto(Photo photo) {
			this.photo = photo;
			return this;
		}

		/**
		 * Contains conversation cover image.
		 */
		public class Photo {
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

			/**
			 * Gets URL of conversation image with width size of 50 px.
			 *
			 * @return URL of conversation image with width size of 50 px.
			 */
			public String getPhoto50() {
				return photo50;
			}

			/**
			 * Sets URL of conversation image with width size of 50 px.
			 *
			 * @param photo50 URL of conversation image with width size of 50 px.
			 * @return this Photo.
			 */
			public Photo setPhoto50(String photo50) {
				this.photo50 = photo50;
				return this;
			}

			/**
			 * Gets URL of conversation image with width size of 100 px.
			 *
			 * @return URL of conversation image with width size of 100 px.
			 */
			public String getPhoto100() {
				return photo100;
			}

			/**
			 * Sets URL of conversation image with width size of 100 px.
			 *
			 * @param photo100 URL of conversation image with width size of 100 px.
			 * @return this Photo.
			 */
			public Photo setPhoto100(String photo100) {
				this.photo100 = photo100;
				return this;
			}

			/**
			 * Gets URL of conversation image with width size of 200 px.
			 *
			 * @return URL of conversation image with width size of 200 px.
			 */
			public String getPhoto200() {
				return photo200;
			}

			/**
			 * Sets URL of conversation image with width size of 200 px.
			 *
			 * @param photo200 URL of conversation image with width size of 200 px.
			 * @return this Photo.
			 */
			public Photo setPhoto200(String photo200) {
				this.photo200 = photo200;
				return this;
			}
		}
	}

	/**
	 * Checks wether message has text.
	 *
	 * @return true if message has text.
	 */
	public boolean hasText() {
		return text != null && !text.isEmpty();
	}

	/**
	 * Checks wether message has attachments.
	 *
	 * @return true if massage has attachments.
	 */
	public boolean hasAttachments() {
		return attachments != null && !attachments.isEmpty();
	}

	/**
	 * Checks wether message has Geo objects.
	 *
	 * @return true if message has Geo objects.
	 */
	public boolean hasGeo() {
		return geo != null;
	}

	/**
	 * Checks wether message has forwarded messages.
	 *
	 * @return true if message has forwarded messages.
	 */
	public boolean hasFwdMessages() {
		return fwdMessages != null && !fwdMessages.isEmpty();
	}

	/**
	 * Checks wether message has reply message.
	 *
	 * @return true if message has reply message.
	 */
	public boolean hasReplyMessage() {
		return replyMessage != null;
	}

	/**
	 * Sets message id.
	 *
	 * @param id message id.
	 * @return this Message.
	 */
	public Message setId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Sets message date.
	 *
	 * @param date message date.
	 * @return this Message.
	 */
	public Message setDate(Integer date) {
		this.date = date;
		return this;
	}

	/**
	 * sets message peer_id.
	 *
	 * @param peerId message peer_id.
	 * @return this Message.
	 */
	public Message setPeerId(Integer peerId) {
		this.peerId = peerId;
		return this;
	}

	/**
	 * Sets message from_id;
	 *
	 * @param fromId message from_id.
	 * @return this Message.
	 */
	public Message setFromId(Integer fromId) {
		this.fromId = fromId;
		return this;
	}

	/**
	 * Sets message text.
	 *
	 * @param text message text.
	 * @return this Message.
	 */
	public Message setText(String text) {
		this.text = text;
		return this;
	}

	/**
	 * Sets message random_id.
	 *
	 * @param randomId message random_id.
	 * @return this Message.
	 */
	public Message setRandomId(Integer randomId) {
		this.randomId = randomId;
		return this;
	}

	/**
	 * Sets message attachments.
	 *
	 * @param attachments list of message attachments.
	 * @return this Message.
	 */
	public Message setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
		return this;
	}

	/**
	 * Sets message important
	 *
	 * @param important message important
	 * @return this Message.
	 */
	public Message setImportant(boolean important) {
		this.important = important;
		return this;
	}

	/**
	 * Sets message geo.
	 *
	 * @param geo message geo.
	 * @return this Message.
	 */
	public Message setGeo(Geo geo) {
		this.geo = geo;
		return this;
	}

	/**
	 * Sets message payload.
	 *
	 * @param payload message payload.
	 * @return this Message.
	 */
	public Message setPayload(String payload) {
		this.payload = payload;
		return this;
	}

	/**
	 * Sets message fwd_messages.
	 *
	 * @param fwdMessages list of forwarded messages.
	 * @return this Message.
	 */
	public Message setFwdMessages(List<Message> fwdMessages) {
		this.fwdMessages = fwdMessages;
		return this;
	}

	/**
	 * Sets message action.
	 *
	 * @param action message action.
	 * @return this Message.
	 */
	public Message setAction(Action action) {
		this.action = action;
		return this;
	}

	/**
	 * Gets message id.
	 *
	 * @return message id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets message date.
	 *
	 * @return message date.
	 */
	public Integer getDate() {
		return date;
	}

	/**
	 * Gets message peer_id.
	 *
	 * @return message peer_id.
	 */
	public Integer getPeerId() {
		return peerId;
	}

	/**
	 * Gets message from_id.
	 *
	 * @return message from_id.
	 */
	public Integer getFromId() {
		return fromId;
	}

	/**
	 * Gets message text.
	 *
	 * @return message text.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets message random_id.
	 *
	 * @return message random_id.
	 */
	public Integer getRandomId() {
		return randomId;
	}

	/**
	 * Gets message attachments.
	 *
	 * @return list of message attachments.
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * Gets message importance.
	 *
	 * @return true if message is important.
	 */
	public boolean isImportant() {
		return important;
	}

	/**
	 * Gets message geo.
	 *
	 * @return message geo.
	 */
	public Geo getGeo() {
		return geo;
	}

	/**
	 * Gets message payload.
	 *
	 * @return message payload.
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Gets message fwd_messages.
	 *
	 * @return list of forwarded messages.
	 */
	public List<Message> getFwdMessages() {
		return fwdMessages;
	}

	/**
	 * Gets message action.
	 *
	 * @return message action.
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Gets message reply_message.
	 *
	 * @return message reply_message.
	 */
	public Message getReplyMessage() {
		return replyMessage;
	}

	/**
	 * Sets message reply_message.
	 *
	 * @param replyMessage reply to message.
	 * @return this Message.
	 */
	public Message setReplyMessage(Message replyMessage) {
		this.replyMessage = replyMessage;
		return this;
	}

	// TODO: 12.08.2020 find out javadoc
	public Integer getConversationMessageId() {
		return conversationMessageId;
	}

	// TODO: 12.08.2020 find out javadoc
	public Message setConversationMessageId(Integer conversationMessageId) {
		this.conversationMessageId = conversationMessageId;
		return this;
	}

	// TODO: 12.08.2020 find out javadoc
	public boolean isHidden() {
		return hidden;
	}

	// TODO: 12.08.2020 find out javadoc
	public Message setHidden(boolean hidden) {
		this.hidden = hidden;
		return this;
	}
}
