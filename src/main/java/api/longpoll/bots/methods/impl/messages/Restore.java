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
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public Restore setMessageId(int messageId) {
        return addParam("message_id", messageId);
    }

    public Restore setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public Restore addParam(String key, Object value) {
        return (Restore) super.addParam(key, value);
    }
}
