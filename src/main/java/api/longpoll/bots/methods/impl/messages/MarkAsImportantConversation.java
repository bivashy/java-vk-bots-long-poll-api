package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>messages.markAsImportantConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsImportantConversation">https://vk.com/dev/messages.markAsImportantConversation</a>
 */
public class MarkAsImportantConversation extends VkMethod<IntegerResponseBody> {

    public MarkAsImportantConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("messages.markAsImportantConversation");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
    }

    public MarkAsImportantConversation setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public MarkAsImportantConversation setAnswered(boolean answered) {
        return addParam("answered", answered ? 1 : 0);
    }

    public MarkAsImportantConversation setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public MarkAsImportantConversation addParam(String key, Object value) {
        return (MarkAsImportantConversation) super.addParam(key, value);
    }
}
