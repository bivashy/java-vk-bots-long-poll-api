package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.enableOnline</b> method.
 *
 * Enables "online" status in the community.
 *
 * @see <a href="https://vk.com/dev/groups.enableOnline">https://vk.com/dev/groups.enableOnline</a>
 */
public class GroupsEnableOnline extends VkApiGetMethod<IntegerResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsEnableOnline(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("groups.enableOnline");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public GroupsEnableOnline setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
