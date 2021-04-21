package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.delete</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.delete">https://vk.com/dev/messages.delete</a>
 */
public class MessagesDelete extends GetMethod<GenericResult<Map<String, Integer>>> {
    /**
     * Message IDs.
     */
    private List<Integer> messageIds;

    /**
     * <b>true</b> to mark message as spam.
     */
    private Boolean spam;

    /**
     * Group ID.
     */
    private Integer groupId;

    /**
     * <b>true</b> to delete message for recipient.
     */
    private Boolean deleteForAll;

    public MessagesDelete(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesDelete();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Map<String, Integer>>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<Map<String, Integer>>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("message_ids", messageIds),
                keyVal("spam", spam, true),
                keyVal("group_id", groupId),
                keyVal("delete_for_all", deleteForAll, true)
        );
    }

    public List<Integer> getMessageIds() {
        return messageIds;
    }

    public MessagesDelete setMessageIds(List<Integer> messageIds) {
        this.messageIds = messageIds;
        return this;
    }

    public Boolean getSpam() {
        return spam;
    }

    public MessagesDelete setSpam(Boolean spam) {
        this.spam = spam;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesDelete setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Boolean getDeleteForAll() {
        return deleteForAll;
    }

    public MessagesDelete setDeleteForAll(Boolean deleteForAll) {
        this.deleteForAll = deleteForAll;
        return this;
    }
}
