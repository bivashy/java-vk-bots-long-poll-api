package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
* Implements <b>messages.getHistory</b> method.
* @see <a href="https://vk.com/dev/messages.getHistory">https://vk.com/dev/messages.getHistory</a>
*/
public class MessagesGetHistory extends GetMethod<MessagesGetHistoryResult> {
    /**
     * Offset needed to return a specific subset of messages.
     */
    private Integer offset;

    /**
     * Number of messages to return.
     */
    private Integer count;

    /**
     * ID of the user whose message history you want to return.
     */
    private String userId;

    /**
     * Peer ID.
     */
    private Integer peerId;

    /**
     * ID of the user whose message history you want to return.
     */
    private Integer startMessageId;

    /**
     * Sort order.
     */
    private Boolean rev;

    /**
     * Extended.
     */
    private Boolean extended;

    /**
     * Additional fields.
     */
    private List<String> fields;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesGetHistory(LongPollBot bot) {
        super(bot);
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetHistory();
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected JsonToPojoConverter<MessagesGetHistoryResult> getConverter() {
        return GenericConverterFactory.get(MessagesGetHistoryResult.class);
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("offset", offset),
                keyVal("count", count),
                keyVal("user_id", userId),
                keyVal("peer_id", peerId),
                keyVal("start_message_id", startMessageId),
                keyVal("rev", rev, true),
                keyVal("extended", extended, true),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    public Integer getOffset() {
        return offset;
    }

    public MessagesGetHistory setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public MessagesGetHistory setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public MessagesGetHistory setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesGetHistory setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Integer getStartMessageId() {
        return startMessageId;
    }

    public MessagesGetHistory setStartMessageId(Integer startMessageId) {
        this.startMessageId = startMessageId;
        return this;
    }

    public Boolean getRev() {
        return rev;
    }

    public MessagesGetHistory setRev(Boolean rev) {
        this.rev = rev;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public MessagesGetHistory setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetHistory setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetHistory setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
