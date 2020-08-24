package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetOnlineStatusResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsGetOnlineStatus extends GetMethod<GroupsGetOnlineStatusResult> {
    private Integer groupId;

    public GroupsGetOnlineStatus(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetOnlineStatus();
    }

    @Override
    protected JsonToPojoConverter<GroupsGetOnlineStatusResult> getConverter() {
        return GenericConverterFactory.get(GroupsGetOnlineStatusResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetOnlineStatus setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
