package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackServersResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getCallbackServers</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackServers">https://vk.com/dev/groups.getCallbackServers</a>
 */
public class GroupsGetCallbackServers extends GetMethod<GroupsGetCallbackServersResult> {
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
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("server_ids", serverIds)
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
