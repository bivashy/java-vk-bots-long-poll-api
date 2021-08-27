package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.editCallbackServer</b> method.
 * <p>
 * Edits Callback API server in the community.
 *
 * @see <a href="https://vk.com/dev/groups.editCallbackServer">https://vk.com/dev/groups.editCallbackServer</a>
 */
public class EditCallbackServer extends AuthorizedVkApiMethod<IntegerResponse> {
    public EditCallbackServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.editCallbackServer");
    }

    @Override
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public EditCallbackServer setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public EditCallbackServer setServerId(int serverId) {
        addParam("server_id", serverId);
        return this;
    }

    public EditCallbackServer setUrl(String url) {
        addParam("url", url);
        return this;
    }

    public EditCallbackServer setTitle(String title) {
        addParam("title", title);
        return this;
    }

    public EditCallbackServer setSecretKey(String secretKey) {
        addParam("secret_key", secretKey);
        return this;
    }
}
