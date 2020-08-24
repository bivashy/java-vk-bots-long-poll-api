package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsSetSettings extends GetMethod<GenericResult<Integer>> {
    private Integer groupId;
    private Boolean messages;
    private Boolean botsCapabilities;
    private Boolean botsAddToChat;

    public GroupsSetSettings(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsSetSettings();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("messages", messages, true),
                keyVal("bots_capabilities", botsCapabilities, true),
                keyVal("bots_add_to_chat", botsAddToChat, true)
        );
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsSetSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Boolean getMessages() {
        return messages;
    }

    public GroupsSetSettings setMessages(Boolean messages) {
        this.messages = messages;
        return this;
    }

    public Boolean getBotsCapabilities() {
        return botsCapabilities;
    }

    public GroupsSetSettings setBotsCapabilities(Boolean botsCapabilities) {
        this.botsCapabilities = botsCapabilities;
        return this;
    }

    public Boolean getBotsAddToChat() {
        return botsAddToChat;
    }

    public GroupsSetSettings setBotsAddToChat(Boolean botsAddToChat) {
        this.botsAddToChat = botsAddToChat;
        return this;
    }
}
