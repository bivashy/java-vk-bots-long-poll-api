package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.deleteCallbackServer</b> method.
 * <p>
 * Deletes Callback API server from the community.
 *
 * @see <a href="https://vk.com/dev/groups.deleteCallbackServer">https://vk.com/dev/groups.deleteCallbackServer</a>
 */
public class DeleteCallbackServer extends AuthorizedVkApiMethod<IntegerResponse> {
    public DeleteCallbackServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.deleteCallbackServer");
    }

    @Override
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public DeleteCallbackServer setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public DeleteCallbackServer setServerId(int serverId) {
        addParam("server_id", serverId);
        return this;
    }
}
