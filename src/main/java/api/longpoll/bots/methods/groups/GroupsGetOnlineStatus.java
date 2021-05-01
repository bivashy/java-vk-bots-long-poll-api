package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetOnlineStatusResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getOnlineStatus</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getOnlineStatus">https://vk.com/dev/groups.getOnlineStatus</a>
 */
public class GroupsGetOnlineStatus extends VkApiGetMethod<GroupsGetOnlineStatusResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetOnlineStatus(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetOnlineStatus();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(param("group_id", groupId));
    }

    @Override
    protected Class<? extends GroupsGetOnlineStatusResult> getResultType() {
        return GroupsGetOnlineStatusResult.class;
    }

    public GroupsGetOnlineStatus setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
