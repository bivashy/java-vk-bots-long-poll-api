package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.response.groups.GroupsGetMembersResultConverterImpl;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetMembersResponseItem;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getMembers</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getMembers">https://vk.com/dev/groups.getMembers</a>
 */
public class GroupsGetMembers extends GetMethod<GenericResult<VkList<GroupsGetMembersResponseItem>>> {
    /**
     * ID or screen name of the community.
     */
    private String groupId;

    /**
     * Sort order. Available values: id_asc, id_desc, time_asc, time_desc.
     */
    private String sort;

    /**
     * Offset needed to return a specific subset of community members.
     */
    private Integer offset;

    /**
     * Number of community members to return.
     */
    private Integer count;

    /**
     * List of additional fields to be returned.
     */
    private List<String> fields;

    /**
     * User filter.
     */
    private String filter;

    public GroupsGetMembers(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetMembers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<VkList<GroupsGetMembersResponseItem>>> getConverter() {
        return new GroupsGetMembersResultConverterImpl();
    }

    /**
     * {@inheritDoc}
     */
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
