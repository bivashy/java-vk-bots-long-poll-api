package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetByIdResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class GroupsGetById extends GetMethod<GroupsGetByIdResult> {
    private List<String> groupIds;
    private String groupId;
    private List<String> fields;

    public GroupsGetById(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetById();
    }

    @Override
    protected JsonToPojoConverter<GroupsGetByIdResult> getConverter() {
        return GenericConverterFactory.get(GroupsGetByIdResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_ids", groupIds),
                keyVal("group_id", groupId),
                keyVal("fields", fields)
        );
    }

    public List<String> getGroupIds() {
        return groupIds;
    }

    public GroupsGetById setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
        return this;
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupsGetById setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public GroupsGetById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
