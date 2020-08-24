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

public class MessagesGetHistory extends GetMethod<MessagesGetHistoryResult> {
    private Integer offset;
    private Integer count;
    private String userId;
    private Integer peerId;
    private Integer startMessageId;
    private Boolean rev;
    private Boolean extended;
    private List<String> fields;
    private Integer groupId;

    public MessagesGetHistory(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetHistory();
    }

    @Override
    protected JsonToPojoConverter<MessagesGetHistoryResult> getConverter() {
        return GenericConverterFactory.get(MessagesGetHistoryResult.class);
    }

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
