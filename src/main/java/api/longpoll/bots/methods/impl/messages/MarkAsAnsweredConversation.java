package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.markAsAnsweredConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsAnsweredConversation">https://vk.com/dev/messages.markAsAnsweredConversation</a>
 */
public class MarkAsAnsweredConversation extends AuthorizedVkApiMethod<IntegerResponse> {
    public MarkAsAnsweredConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.markAsAnsweredConversation");
    }

    @Override
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public MarkAsAnsweredConversation setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public MarkAsAnsweredConversation setAnswered(boolean answered) {
        addParam("answered", new BoolInt(answered));
        return this;
    }

    public MarkAsAnsweredConversation setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }
}
