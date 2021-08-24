package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollSettingsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getLongPollSettings</b> method.
 *
 * Returns Bots Long Poll API settings.
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
        return VkApiProperties.get("groups.getLongPollSettings");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(keyVal("group_id", groupId));
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
