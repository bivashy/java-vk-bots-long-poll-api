package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.markAsImportantConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsImportantConversation">https://vk.com/dev/messages.markAsImportantConversation</a>
 */
public class MarkAsImportantConversation extends AuthorizedVkApiMethod<IntegerResponse> {
    public MarkAsImportantConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.markAsImportantConversation");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public MarkAsImportantConversation setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public MarkAsImportantConversation setAnswered(boolean answered) {
        return addParam("answered", new BoolInt(answered));
    }

    public MarkAsImportantConversation setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public MarkAsImportantConversation addParam(String key, Object value) {
        return (MarkAsImportantConversation) super.addParam(key, value);
    }
}
