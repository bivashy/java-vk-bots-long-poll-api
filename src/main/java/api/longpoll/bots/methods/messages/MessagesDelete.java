package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.IntegerResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesDelete extends GetMethod<IntegerResult> {
    private List<Integer> messageIds;
    private Boolean spam;
    private Integer groupId;
    private Boolean deleteForAll;

    public MessagesDelete(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.DELETE;
    }

    @Override
    protected JsonToPojoConverter<IntegerResult> getConverter() {
        return GenericConverterFactory.get(IntegerResult.class);
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
