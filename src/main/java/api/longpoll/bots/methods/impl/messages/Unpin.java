package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>messages.unpin</b> method.
 * <p>
 * Unpins message.
 *
 * @see <a href="https://vk.com/dev/messages.unpin">https://vk.com/dev/messages.unpin</a>
 */
public class Unpin extends VkMethod<IntegerResponseBody> {
    public Unpin(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("messages.unpin");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
    }

    public Unpin setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public Unpin setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public Unpin addParam(String key, Object value) {
        return (Unpin) super.addParam(key, value);
    }
}
