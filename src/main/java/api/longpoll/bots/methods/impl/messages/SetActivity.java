package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.setActivity</b> method.
 * <p>
 * Changes the status of a user as typing in a conversation.
 *
 * @see <a href="https://vk.com/dev/messages.setActivity">https://vk.com/dev/messages.setActivity</a>
 */
public class SetActivity extends AuthorizedVkApiMethod<IntegerResponse> {
    public SetActivity(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.setActivity");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public SetActivity setUserId(int userId) {
        addParam("user_id", userId);
        return this;
    }

    public SetActivity setType(String type) {
        addParam("type", type);
        return this;
    }

    public SetActivity setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public SetActivity setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }
}
