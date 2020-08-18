package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.response.groups.GroupsGetMembersResultConverterImpl;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetMembersResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class GroupsGetMembers extends GetMethod<GroupsGetMembersResult> {
    private String groupId;
    private String sort;
    private Integer offset;
    private Integer count;
    private List<String> fields;
    private String filter;

    public GroupsGetMembers(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Groups.GET_MEMBERS;
    }

    @Override
    protected JsonToPojoConverter<GroupsGetMembersResult> getConverter() {
        return new GroupsGetMembersResultConverterImpl();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("sort", sort),
                keyVal("offset", offset),
                keyVal("count", count),
                keyVal("fields", fields),
                keyVal("filter", filter)
        );
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupsGetMembers setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public GroupsGetMembers setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public GroupsGetMembers setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public GroupsGetMembers setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public GroupsGetMembers setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public String getFilter() {
        return filter;
    }

    public GroupsGetMembers setFilter(String filter) {
        this.filter = filter;
        return this;
    }
}
