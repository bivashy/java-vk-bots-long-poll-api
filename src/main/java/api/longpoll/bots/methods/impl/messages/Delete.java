package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;

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
public class Delete extends VkMethod<Delete.ResponseBody> {
    public Delete(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("messages.delete");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    public Delete setMessageIds(Integer... messageIds) {
        return setMessageIds(Arrays.asList(messageIds));
    }

    public Delete setMessageIds(List<Integer> messageIds) {
        return addParam("message_ids", toCommaSeparatedValues(messageIds));
    }

    public Delete setSpam(boolean spam) {
        return addParam("spam", spam ? 1 : 0);
    }

    public Delete setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public Delete setDeleteForAll(boolean deleteForAll) {
        return addParam("delete_for_all", deleteForAll ? 1 : 0);
    }

    public Delete setConversationMessageIds(Integer... conversationMessageIds) {
        return setConversationMessageIds(Arrays.asList(conversationMessageIds));
    }

    public Delete setConversationMessageIds(List<Integer> conversationMessageIds) {
        return addParam("conversation_message_ids", toCommaSeparatedValues(conversationMessageIds));
    }

    public Delete setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    @Override
    public Delete addParam(String key, Object value) {
        return (Delete) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.delete</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<Map<String, Integer>> {
    }
}
