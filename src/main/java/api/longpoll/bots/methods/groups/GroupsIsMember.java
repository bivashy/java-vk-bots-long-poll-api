package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsIsMemberResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>groups.isMember</b> method.
 *
 * Returns information specifying whether a user is a member of a community.
 *
 * @see <a href="https://vk.com/dev/groups.isMember">https://vk.com/dev/groups.isMember</a>
 */
public class GroupsIsMember extends VkApiGetMethod<GroupsIsMemberResult> {
    /**
     * ID or screen name of the community.
     */
    private String groupId;

    /**
     * User ID.
     */
    private Integer userId;

    /**
     * User IDs.
     */
    private List<Integer> userIds;

    /**
     * <b>true</b> to return an extended response with additional fields.
     */
    private Boolean extended;

    public GroupsIsMember(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsIsMember();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("user_id", userId),
                keyVal("user_ids", userIds),
                keyVal("extended", extended, true)
        );
    }

    @Override
    protected Class<? extends GroupsIsMemberResult> getResultType() {
        return GroupsIsMemberResult.class;
    }

    public GroupsIsMember setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsIsMember setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public GroupsIsMember setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }

    public GroupsIsMember setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }
}
