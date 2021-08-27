package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.restore</b> method.
 * <p>
 * Restores a deleted message.
 *
 * @see <a href="https://vk.com/dev/messages.restore">https://vk.com/dev/messages.restore</a>
 */
public class Restore extends AuthorizedVkApiMethod<IntegerResponse> {
    public Restore(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.restore");
    }

    @Override
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public Restore setMessageId(int messageId) {
        addParam("message_id", messageId);
        return this;
    }

    public Restore setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }
}
