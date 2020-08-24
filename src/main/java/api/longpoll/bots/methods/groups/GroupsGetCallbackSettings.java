package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackSettingsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsGetCallbackSettings extends GetMethod<GroupsGetCallbackSettingsResult> {
    private Integer groupId;
    private Integer serverId;

    public GroupsGetCallbackSettings(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetCallbackSettings();
    }

    @Override
    protected JsonToPojoConverter<GroupsGetCallbackSettingsResult> getConverter() {
        return GenericConverterFactory.get(GroupsGetCallbackSettingsResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("server_id", serverId)
        );
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetCallbackSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getServerId() {
        return serverId;
    }

    public GroupsGetCallbackSettings setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }
}
