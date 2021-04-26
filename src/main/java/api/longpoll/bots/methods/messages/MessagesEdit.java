package api.longpoll.bots.methods.messages;

import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.response.IntegerResult;
import api.longpoll.bots.utils.methods.AttachmentsUtil;
import api.longpoll.bots.utils.methods.MessagesUtil;
import org.jsoup.Connection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>messages.edit</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.edit">https://vk.com/dev/messages.edit</a>
 */
public class MessagesEdit extends GetMethod<IntegerResult> {
    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * Text of the message.
     */
    private String message;

    /**
     * Geographical latitude of a check-in, in degrees (from -90 to 90).
     */
    private Float latitude;

    /**
     * Geographical longitude of a check-in, in degrees (from -180 to 180).
     */
    private Float longitude;

    /**
     * List of objects attached to the message.
     */
    private List<String> attachments = new ArrayList<>();

    /**
     * <b>true</b> to keep forwarded, messages.
     */
    private Boolean keepForwardMessages;

    /**
     * <b>true</b> to keep attached snippets.
     */
    private Boolean keepSnippets;

    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * <b>true</b> not to parse links.
     */
    private Boolean dontParseLinks;

    /**
     * Message ID.
     */
    private Integer messageId;

    /**
     * Conversation message ID.
     */
    private Integer conversationMessageId;

    /**
     * Photos to be attached.
     */
    private List<File> photos = new ArrayList<>();

    /**
     * Docs to be attached.
     */
    private List<File> docs = new ArrayList<>();

    public MessagesEdit(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesEdit();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("message", message),
                keyVal("lat", latitude),
                keyVal("long", longitude),
                keyVal("attachment", attachments),
                keyVal("keep_forward_messages", keepForwardMessages, true),
                keyVal("keep_snippets", keepSnippets, true),
                keyVal("group_id", groupId),
                keyVal("dont_parse_links", dontParseLinks, true),
                keyVal("message_id", messageId),
                keyVal("conversation_message_id", conversationMessageId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    @Override
    public IntegerResult execute() throws BotsLongPollAPIException, BotsLongPollException {
        for (File photo : photos) {
            addAttachment(AttachmentsUtil.toAttachment(MessagesUtil.uploadPhoto(accessToken, peerId, photo)));
        }
        for (File doc : docs) {
            addAttachment(AttachmentsUtil.toAttachment(MessagesUtil.uploadDoc(accessToken, peerId, doc)));
        }
        return super.execute();
    }

    private MessagesEdit addAttachment(String attachment) {
        attachments.add(attachment);
        return this;
    }

    public MessagesEdit addPhoto(Photo photo) {
        return addAttachment(AttachmentsUtil.toAttachment(photo));
    }

    public MessagesEdit addPhoto(File photo) {
        photos.add(photo);
        return this;
    }

    public MessagesEdit addDoc(Doc doc) {
        return addAttachment(AttachmentsUtil.toAttachment(doc));
    }

    public MessagesEdit addDoc(File doc) {
        docs.add(doc);
        return this;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesEdit setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessagesEdit setMessage(String message) {
        this.message = message;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public MessagesEdit setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public MessagesEdit setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public MessagesEdit setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Boolean getKeepForwardMessages() {
        return keepForwardMessages;
    }

    public MessagesEdit setKeepForwardMessages(Boolean keepForwardMessages) {
        this.keepForwardMessages = keepForwardMessages;
        return this;
    }

    public Boolean getKeepSnippets() {
        return keepSnippets;
    }

    public MessagesEdit setKeepSnippets(Boolean keepSnippets) {
        this.keepSnippets = keepSnippets;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesEdit setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Boolean getDontParseLinks() {
        return dontParseLinks;
    }

    public MessagesEdit setDontParseLinks(Boolean dontParseLinks) {
        this.dontParseLinks = dontParseLinks;
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public MessagesEdit setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public Integer getConversationMessageId() {
        return conversationMessageId;
    }

    public MessagesEdit setConversationMessageId(Integer conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
        return this;
    }
}
