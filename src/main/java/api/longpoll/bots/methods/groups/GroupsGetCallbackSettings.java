package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackSettingsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getCallbackSettings</b> method.
 *
 * Returns Callback API notifications settings.
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
        return VkApiProperties.get("groups.getCallbackSettings");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("server_id", serverId)
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
