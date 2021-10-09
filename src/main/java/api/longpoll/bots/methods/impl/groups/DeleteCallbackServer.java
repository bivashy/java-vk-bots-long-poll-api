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
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public DeleteCallbackServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public DeleteCallbackServer setServerId(int serverId) {
        return addParam("server_id", serverId);
    }

    @Override
    public DeleteCallbackServer addParam(String key, Object value) {
        return (DeleteCallbackServer) super.addParam(key, value);
    }
}
