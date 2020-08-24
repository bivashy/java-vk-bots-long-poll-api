package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollSettingsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsGetLongPollSettings extends GetMethod<GroupsGetLongPollSettingsResult> {
    private Integer groupId;

    public GroupsGetLongPollSettings(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetLongPollSettings();
    }

    @Override
    protected JsonToPojoConverter<GroupsGetLongPollSettingsResult> getConverter() {
        return GenericConverterFactory.get(GroupsGetLongPollSettingsResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetLongPollSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
