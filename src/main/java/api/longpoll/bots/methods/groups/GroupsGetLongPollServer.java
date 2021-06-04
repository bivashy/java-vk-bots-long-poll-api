package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getLongPollServer</b> method.
 *
 * Returns data for Bots Long Poll API connection.
 *
 * @see <a href="https://vk.com/dev/groups.getLongPollServer">https://vk.com/dev/groups.getLongPollServer</a>
 */
public class GroupsGetLongPollServer extends VkApiGetMethod<GroupsGetLongPollServerResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetLongPollServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    @Override
    protected Class<? extends GroupsGetLongPollServerResult> getResultType() {
        return GroupsGetLongPollServerResult.class;
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetLongPollServer();
    }

    public GroupsGetLongPollServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
