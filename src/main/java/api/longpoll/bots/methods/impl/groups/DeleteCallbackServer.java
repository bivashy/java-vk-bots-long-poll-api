package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>groups.deleteCallbackServer</b> method.
 * <p>
 * Deletes Callback API server from the community.
 *
 * @see <a href="https://vk.com/dev/groups.deleteCallbackServer">https://vk.com/dev/groups.deleteCallbackServer</a>
 */
public class DeleteCallbackServer extends VkMethod<IntegerResponseBody> {
    public DeleteCallbackServer(String accessToken) {
        super(property("groups.deleteCallbackServer"), accessToken);
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
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
