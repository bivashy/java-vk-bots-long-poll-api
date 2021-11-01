package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.enableOnline</b> method.
 * <p>
 * Enables "online" status in the community.
 *
 * @see <a href="https://vk.com/dev/groups.enableOnline">https://vk.com/dev/groups.enableOnline</a>
 */
public class EnableOnline extends AuthorizedVkApiMethod<IntegerResponse> {
    public EnableOnline(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.enableOnline");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public EnableOnline setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public EnableOnline addParam(String key, Object value) {
        return (EnableOnline) super.addParam(key, value);
    }
}
