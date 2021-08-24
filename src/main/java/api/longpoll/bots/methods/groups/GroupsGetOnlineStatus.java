package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.groups.GroupsGetOnlineStatusResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getOnlineStatus</b> method.
 *
 * Returns a community's online status.
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
        return VkApiProperties.get("groups.getOnlineStatus");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(keyVal("group_id", groupId));
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
