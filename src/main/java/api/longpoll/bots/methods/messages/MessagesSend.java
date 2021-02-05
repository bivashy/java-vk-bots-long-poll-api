package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.response.messages.MessagesSendResultConverter;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.exceptions.BotsLongPollHttpException;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.Template;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.response.GenericResult;
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
 * @see <a href="https://vk.com/dev/messages.send">https://vk.com/dev/messages.send</a>
 */
public class MessagesSend extends GetMethod<GenericResult<Object>> {
    private static final JsonToPojoConverter<GenericResult<Object>> MESSAGES_SEND_RESULT_CONVERTER = new MessagesSendResultConverter();

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
    private List<String> attachments;

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

    public MessagesSend(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesSend();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Object>> getConverter() {
        return MESSAGES_SEND_RESULT_CONVERTER;
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

    private MessagesSend attach(String attachment) {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        attachments.add(attachment);
        return this;
    }

    public MessagesSend attachPhoto(Photo photo) {
        return attach(AttachmentsUtil.toAttachment(photo));
    }

    public MessagesSend attachPhoto(File photo) throws BotsLongPollHttpException, BotsLongPollException {
        return attach(AttachmentsUtil.toAttachment(MessagesUtil.uploadPhoto(bot, getPeerId(), photo)));
    }

    public MessagesSend attachDoc(Doc doc) {
        return attach(AttachmentsUtil.toAttachment(doc));
    }

    public MessagesSend attachDoc(File doc) throws BotsLongPollHttpException, BotsLongPollException {
        return attachDoc(MessagesUtil.uploadDoc(bot, peerId, doc));
    }

    public Integer getUserId() {
        return userId;
    }

    public MessagesSend setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getRandomId() {
        return randomId;
    }

    public MessagesSend setRandomId(Integer randomId) {
        this.randomId = randomId;
        return this;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesSend setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public MessagesSend setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Integer getChatId() {
        return chatId;
    }

    public MessagesSend setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public MessagesSend setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessagesSend setMessage(String message) {
        this.message = message;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public MessagesSend setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public MessagesSend setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public MessagesSend setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Integer getReplyTo() {
        return replyTo;
    }

    public MessagesSend setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public List<Integer> getForwardMessages() {
        return forwardMessages;
    }

    public MessagesSend setForwardMessages(List<Integer> forwardMessages) {
        this.forwardMessages = forwardMessages;
        return this;
    }

    public Integer getStickerId() {
        return stickerId;
    }

    public MessagesSend setStickerId(Integer stickerId) {
        this.stickerId = stickerId;
        return this;
    }

    public Boolean getDontParseLinks() {
        return dontParseLinks;
    }

    public MessagesSend setDontParseLinks(Boolean dontParseLinks) {
        this.dontParseLinks = dontParseLinks;
        return this;
    }

    public Boolean getDisableMentions() {
        return disableMentions;
    }

    public MessagesSend setDisableMentions(Boolean disableMentions) {
        this.disableMentions = disableMentions;
        return this;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public MessagesSend setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public Template getTemplate() {
        return template;
    }

    public MessagesSend setTemplate(Template template) {
        this.template = template;
        return this;
    }
}
