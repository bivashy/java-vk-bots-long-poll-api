package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollSettingsResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getLongPollSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getLongPollSettings">https://vk.com/dev/groups.getLongPollSettings</a>
 */
public class GroupsGetLongPollSettings extends VkApiGetMethod<GroupsGetLongPollSettingsResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetLongPollSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetLongPollSettings();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(param("group_id", groupId));
    }

    @Override
    protected Class<? extends GroupsGetLongPollSettingsResult> getResultType() {
        return GroupsGetLongPollSettingsResult.class;
    }

    public GroupsGetLongPollSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
