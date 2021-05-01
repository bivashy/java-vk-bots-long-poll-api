package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackSettingsResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getCallbackSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackSettings">https://vk.com/dev/groups.getCallbackSettings</a>
 */
public class GroupsGetCallbackSettings extends VkApiGetMethod<GroupsGetCallbackSettingsResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Server ID.
     */
    private Integer serverId;

    public GroupsGetCallbackSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetCallbackSettings();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("group_id", groupId),
                param("server_id", serverId)
        );
    }

    @Override
    protected Class<? extends GroupsGetCallbackSettingsResult> getResultType() {
        return GroupsGetCallbackSettingsResult.class;
    }

    public GroupsGetCallbackSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsGetCallbackSettings setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }
}
