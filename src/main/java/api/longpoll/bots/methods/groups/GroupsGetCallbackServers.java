package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackServersResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getCallbackServers</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackServers">https://vk.com/dev/groups.getCallbackServers</a>
 */
public class GroupsGetCallbackServers extends VkApiGetMethod<GroupsGetCallbackServersResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Servers IDs to return.
     */
    private List<Integer> serverIds;

    public GroupsGetCallbackServers(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetCallbackServers();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("group_id", groupId),
                param("server_ids", serverIds)
        );
    }

    @Override
    protected Class<? extends GroupsGetCallbackServersResult> getResultType() {
        return GroupsGetCallbackServersResult.class;
    }

    public GroupsGetCallbackServers setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsGetCallbackServers setServerIds(List<Integer> serverIds) {
        this.serverIds = serverIds;
        return this;
    }
}
