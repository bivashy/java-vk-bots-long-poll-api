package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.disableOnline</b> method.
 *
 * Disables "online" status in the community.
 *
 * @see <a href="https://vk.com/dev/groups.disableOnline">https://vk.com/dev/groups.disableOnline</a>
 */
public class GroupsDisableOnline extends VkApiGetMethod<IntegerResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsDisableOnline(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("groups.disableOnline");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public GroupsDisableOnline setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
