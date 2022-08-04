package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getConversationsById</b> method.
 * <p>
 * Returns conversations by their IDs.
 *
 * @see <a href="https://vk.com/dev/messages.getConversationsById">https://vk.com/dev/messages.getConversationsById</a>
 */
public class GetConversationsById extends VkMethod<GetConversationsById.ResponseBody> {
    public GetConversationsById(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return VK_METHODS.getProperty("messages.getConversationsById");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    public GetConversationsById setPeerIds(Integer... peerIds) {
        return setPeerIds(Arrays.asList(peerIds));
    }

    public GetConversationsById setPeerIds(List<Integer> peerIds) {
        return addParam("peer_ids", toCSV(peerIds));
    }

    public GetConversationsById setExtended(boolean extended) {
        return addParam("extended", extended ? 1 : 0);
    }

    public GetConversationsById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetConversationsById setFields(List<String> fields) {
        return addParam("fields", toCSV(fields));
    }

    public GetConversationsById setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetConversationsById addParam(String key, Object value) {
        return (GetConversationsById) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getConversationsById</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ExtendedVkList<Conversation>> {
    }
}
