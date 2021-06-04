package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetBannedResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getBanned</b> method.
 *
 * Returns a list of users on a community blacklist.
 *
 * @see <a href="https://vk.com/dev/groups.getBanned">https://vk.com/dev/groups.getBanned</a>
 */
public class GroupsGetBanned extends VkApiGetMethod<GroupsGetBannedResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Offset needed to return a specific subset of users.
     */
    private Integer offset;

    /**
     * Number of users to return.
     */
    private Integer count;

    /**
     * List of fields of groups and profiles to return.
     */
    private List<String> fields;

    /**
     * User or community ID from the blacklist to return information about.
     */
    private Integer ownerId;

    public GroupsGetBanned(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetBanned();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("offset", offset),
                keyVal("count", count),
                keyVal("fields", fields),
                keyVal("owner_id", ownerId)
        );
    }

    @Override
    protected Class<? extends GroupsGetBannedResult> getResultType() {
        return GroupsGetBannedResult.class;
    }

    public GroupsGetBanned setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsGetBanned setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public GroupsGetBanned setCount(Integer count) {
        this.count = count;
        return this;
    }

    public GroupsGetBanned setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public GroupsGetBanned setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }
}
