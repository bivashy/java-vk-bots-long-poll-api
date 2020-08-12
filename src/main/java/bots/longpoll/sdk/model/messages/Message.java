package bots.longpoll.sdk.model.messages;

import bots.longpoll.sdk.model.attachment.Attachment;
import bots.longpoll.sdk.model.geo.Geo;
import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Message object
 */
public class Message extends UpdateObject {
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

	@SerializedName("hidden")
	private boolean hidden;

	/**
	 * Information about service action with conversation
	 */
	@SerializedName("action")
	private Action action;

	@SerializedName("conversation_message_id")
	private Integer conversationMessageId;

	public boolean hasText() {
		return text != null && !text.isEmpty();
	}

	public boolean hasRandomId() {
		return randomId != null;
	}

	public boolean hasAttachments() {
		return attachments != null && !attachments.isEmpty();
	}

	public boolean hasGeo() {
		return geo != null;
	}

	public boolean hasPayload() {
		return payload != null && !payload.isEmpty();
	}

	public boolean hasFwdMessages() {
		return fwdMessages != null && !fwdMessages.isEmpty();
	}

	public boolean hasReplyMessage() {
		return replyMessage != null;
	}

	public Message setId(Integer id) {
		this.id = id;
		return this;
	}

	public Message setDate(Integer date) {
		this.date = date;
		return this;
	}

	public Message setPeerId(Integer peerId) {
		this.peerId = peerId;
		return this;
	}

	public Message setFromId(Integer fromId) {
		this.fromId = fromId;
		return this;
	}

	public Message setText(String text) {
		this.text = text;
		return this;
	}

	public Message setRandomId(Integer randomId) {
		this.randomId = randomId;
		return this;
	}

	public Message setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
		return this;
	}

	public Message setImportant(boolean important) {
		this.important = important;
		return this;
	}

	public Message setGeo(Geo geo) {
		this.geo = geo;
		return this;
	}

	public Message setPayload(String payload) {
		this.payload = payload;
		return this;
	}

	public Message setFwdMessages(List<Message> fwdMessages) {
		this.fwdMessages = fwdMessages;
		return this;
	}

	public Message setAction(Action action) {
		this.action = action;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public Integer getDate() {
		return date;
	}

	public Integer getPeerId() {
		return peerId;
	}

	public Integer getFromId() {
		return fromId;
	}

	public String getText() {
		return text;
	}

	public Integer getRandomId() {
		return randomId;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public boolean isImportant() {
		return important;
	}

	public Geo getGeo() {
		return geo;
	}

	public String getPayload() {
		return payload;
	}

	public List<Message> getFwdMessages() {
		return fwdMessages;
	}

	public Action getAction() {
		return action;
	}

	public Message getReplyMessage() {
		return replyMessage;
	}

	public Message setReplyMessage(Message replyMessage) {
		this.replyMessage = replyMessage;
		return this;
	}

	public Integer getConversationMessageId() {
		return conversationMessageId;
	}

	public Message setConversationMessageId(Integer conversationMessageId) {
		this.conversationMessageId = conversationMessageId;
		return this;
	}

	public boolean isHidden() {
		return hidden;
	}

	public Message setHidden(boolean hidden) {
		this.hidden = hidden;
		return this;
	}
}
