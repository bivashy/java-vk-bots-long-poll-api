package api.longpoll.bots.methods.messages;

import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.Template;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.response.messages.MessagesSendResult;
import api.longpoll.bots.utils.methods.AttachmentsUtil;
import api.longpoll.bots.utils.methods.MessagesUtil;
import org.jsoup.Connection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>messages.send</b> method.
 *
 * Sends a message.
 *
 * @see <a href="https://vk.com/dev/messages.send">https://vk.com/dev/messages.send</a>
 */
public class MessagesSend extends VkApiGetMethod<MessagesSendResult> {
    /**
     * User ID.
     */
    private Integer userId;

    /**
     * Unique identifier to avoid resending the message.
     */
    private Integer randomId = Long.valueOf(System.currentTimeMillis()).intValue();

    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * User's short address (for example, illarionov).
     */
    private String domain;

    /**
     * ID of conversation the message will relate to.
     */
    private Integer chatId;

    /**
     * IDs of message recipients (if new conversation shall be started).
     */
    private List<Integer> userIds;

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
     * Id of replied message.
     */
    private Integer replyTo;

    /**
     * ID of forwarded messages.
     */
    private List<Integer> forwardMessages;

    /**
     * Sticker id.
     */
    private Integer stickerId;

    /**
     * Keyboard object.
     */
    private Keyboard keyboard;

    /**
     * Template object.
     */
    private Template template;

    /**
     * <b>true</b> - links will not attach snippet.
     */
    private Boolean dontParseLinks;

    /**
     * <b>true</b> - mention of user will not generate notification for him.
     */
    private Boolean disableMentions;

    /**
     * Photos to be attached.
     */
    private List<File> photos = new ArrayList<>();

    /**
     * Docs to be attached.
     */
    private List<File> docs = new ArrayList<>();

    public MessagesSend(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesSend();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("user_id", userId),
                keyVal("random_id", randomId),
                keyVal("peer_id", peerId),
                keyVal("domain", domain),
                keyVal("user_ids", userId),
                keyVal("user_ids", userIds),
                keyVal("message", message),
                keyVal("lat", latitude),
                keyVal("long", longitude),
                keyVal("attachment", attachments),
                keyVal("reply_to", replyTo),
                keyVal("forward_messages", forwardMessages),
                keyVal("sticker_id", stickerId),
                keyVal("dont_parse_links", dontParseLinks, true),
                keyVal("disable_mentions", disableMentions, true),
                keyVal("keyboard", keyboard),
                keyVal("template", template)
        );
    }

    @Override
    protected Class<? extends MessagesSendResult> getResultType() {
        return MessagesSendResult.class;
    }

    @Override
    public MessagesSendResult execute() throws BotsLongPollAPIException, BotsLongPollException {
        for (File photo : photos) {
            addAttachment(AttachmentsUtil.toAttachment(MessagesUtil.uploadPhoto(accessToken, peerId, photo)));
        }
        for (File doc : docs) {
            addAttachment(AttachmentsUtil.toAttachment(MessagesUtil.uploadDoc(accessToken, peerId, doc)));
        }
        return super.execute();
    }

    private MessagesSend addAttachment(String attachment) {
        attachments.add(attachment);
        return this;
    }

    public MessagesSend addPhoto(Photo photo) {
        return addAttachment(AttachmentsUtil.toAttachment(photo));
    }

    public MessagesSend addPhoto(File photo) {
        photos.add(photo);
        return this;
    }

    public MessagesSend addDoc(Doc doc) {
        return addAttachment(AttachmentsUtil.toAttachment(doc));
    }

    public MessagesSend addDoc(File doc) {
        docs.add(doc);
        return this;
    }

    public MessagesSend setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public MessagesSend setRandomId(Integer randomId) {
        this.randomId = randomId;
        return this;
    }

    public MessagesSend setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesSend setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public MessagesSend setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public MessagesSend setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }

    public MessagesSend setMessage(String message) {
        this.message = message;
        return this;
    }

    public MessagesSend setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public MessagesSend setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public MessagesSend setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    public MessagesSend setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public MessagesSend setForwardMessages(List<Integer> forwardMessages) {
        this.forwardMessages = forwardMessages;
        return this;
    }

    public MessagesSend setStickerId(Integer stickerId) {
        this.stickerId = stickerId;
        return this;
    }

    public MessagesSend setDontParseLinks(Boolean dontParseLinks) {
        this.dontParseLinks = dontParseLinks;
        return this;
    }

    public MessagesSend setDisableMentions(Boolean disableMentions) {
        this.disableMentions = disableMentions;
        return this;
    }

    public MessagesSend setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public MessagesSend setTemplate(Template template) {
        this.template = template;
        return this;
    }
}
