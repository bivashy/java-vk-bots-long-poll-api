package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.disableOnline</b> method.
 * <p>
 * Disables "online" status in the community.
 *
 * @see <a href="https://vk.com/dev/groups.disableOnline">https://vk.com/dev/groups.disableOnline</a>
 */
public class DisableOnline extends AuthorizedVkApiMethod<IntegerResponse> {
    public DisableOnline(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.disableOnline");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public DisableOnline setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public DisableOnline addParam(String key, Object value) {
        return (DisableOnline) super.addParam(key, value);
    }
}
