package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.markAsRead</b> method.
 * <p>
 * Marks messages as read.
 *
 * @see <a href="https://vk.com/dev/messages.markAsRead">https://vk.com/dev/messages.markAsRead</a>
 */
public class MarkAsRead extends AuthorizedVkApiMethod<IntegerResponse> {
    public MarkAsRead(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.markAsRead");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public MarkAsRead setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public MarkAsRead setStartMessageId(int startMessageId) {
        addParam("start_message_id", startMessageId);
        return this;
    }

    public MarkAsRead setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public MarkAsRead setMarkConversationAsRead(boolean markConversationAsRead) {
        addParam("mark_conversation_as_read", new BoolInt(markConversationAsRead));
        return this;
    }
}
