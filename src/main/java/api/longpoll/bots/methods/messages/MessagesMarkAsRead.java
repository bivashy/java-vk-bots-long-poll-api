package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesMarkAsRead extends GetMethod<GenericResult<Integer>> {
    private List<Integer> messageIds;
    private String peerId;
    private Integer startMessageId;
    private Integer groupId;
    private Boolean markConversationAsRead;

    public MessagesMarkAsRead(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.MARK_AS_READ;
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("message_ids", messageIds),
                keyVal("peer_id", peerId),
                keyVal("start_message_id", startMessageId),
                keyVal("group_id", groupId),
                keyVal("mark_conversation_as_read", markConversationAsRead, true)
        );
    }

    public List<Integer> getMessageIds() {
        return messageIds;
    }

    public MessagesMarkAsRead setMessageIds(List<Integer> messageIds) {
        this.messageIds = messageIds;
        return this;
    }

    public String getPeerId() {
        return peerId;
    }

    public MessagesMarkAsRead setPeerId(String peerId) {
        this.peerId = peerId;
        return this;
    }

    public Integer getStartMessageId() {
        return startMessageId;
    }

    public MessagesMarkAsRead setStartMessageId(Integer startMessageId) {
        this.startMessageId = startMessageId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesMarkAsRead setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Boolean getMarkConversationAsRead() {
        return markConversationAsRead;
    }

    public MessagesMarkAsRead setMarkConversationAsRead(Boolean markConversationAsRead) {
        this.markConversationAsRead = markConversationAsRead;
        return this;
    }
}
