package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetByIdResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getById</b> method.
 *
 * Returns information about communities by their IDs.
 *
 * @see <a href="https://vk.com/dev/groups.getById">https://vk.com/dev/groups.getById</a>
 */
public class GroupsGetById extends VkApiGetMethod<GroupsGetByIdResult> {
    /**
     * IDs or screen names of communities.
     */
    private List<String> groupIds;

    /**
     * ID or screen name of the community.
     */
    private String groupId;

    /**
     * Group fields to return.
     */
    private List<String> fields;

    public GroupsGetById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetById();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_ids", groupIds),
                keyVal("group_id", groupId),
                keyVal("fields", fields)
        );
    }

    @Override
    protected Class<? extends GroupsGetByIdResult> getResultType() {
        return GroupsGetByIdResult.class;
    }

    public GroupsGetById setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
        return this;
    }

    public GroupsGetById setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsGetById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
