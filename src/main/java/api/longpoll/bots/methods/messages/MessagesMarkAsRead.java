package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.markAsRead</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsRead">https://vk.com/dev/messages.markAsRead</a>
 */
public class MessagesMarkAsRead extends GetMethod<GenericResult<Integer>> {
    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * Message ID to start from.
     */
    private Integer startMessageId;

    /**
     * Group ID.
     */
    private Integer groupId;

    /**
     * <b>true</b> to mark as read.
     */
    private Boolean markConversationAsRead;

    public MessagesMarkAsRead(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesMarkAsRead();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("start_message_id", startMessageId),
                keyVal("group_id", groupId),
                keyVal("mark_conversation_as_read", markConversationAsRead, true)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesMarkAsRead setPeerId(Integer peerId) {
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
