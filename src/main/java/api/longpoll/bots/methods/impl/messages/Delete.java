package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Implements <b>messages.delete</b> method.
 * <p>
 * Deletes one or more messages.
 *
 * @see <a href="https://vk.com/dev/messages.delete">https://vk.com/dev/messages.delete</a>
 */
public class Delete extends AuthorizedVkApiMethod<Delete.Response> {
    public Delete(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.delete");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public Delete setMessageIds(Integer... messageIds) {
        return setMessageIds(Arrays.asList(messageIds));
    }

    public Delete setMessageIds(List<Integer> messageIds) {
        addParam("message_ids", messageIds);
        return this;
    }

    public Delete setSpam(boolean spam) {
        addParam("spam", new BoolInt(spam));
        return this;
    }

    public Delete setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public Delete setDeleteForAll(boolean deleteForAll) {
        addParam("delete_for_all", new BoolInt(deleteForAll));
        return this;
    }

    public Delete setConversationMessageIds(Integer... conversationMessageIds) {
        return setConversationMessageIds(Arrays.asList(conversationMessageIds));
    }

    public Delete setConversationMessageIds(List<Integer> conversationMessageIds) {
        addParam("conversation_message_ids", conversationMessageIds);
        return this;
    }

    public Delete setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    /**
     * Response to <b>messages.delete</b> request.
     */
    public static class Response extends GenericResponse<Map<String, Integer>> {
    }
}
