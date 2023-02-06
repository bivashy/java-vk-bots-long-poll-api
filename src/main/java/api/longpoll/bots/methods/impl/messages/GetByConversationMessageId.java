package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.GenericResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getByConversationMessageId</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getByConversationMessageId">https://vk.com/dev/messages.getByConversationMessageId</a>
 */
public class GetByConversationMessageId extends VkMethod<GetByConversationMessageId.ResponseBody> {
    public GetByConversationMessageId(String accessToken) {
        super(property("messages.getByConversationMessageId"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetByConversationMessageId setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public GetByConversationMessageId setConversationMessageIds(Integer... conversationMessageIds) {
        return setConversationMessageIds(Arrays.asList(conversationMessageIds));
    }

    public GetByConversationMessageId setConversationMessageIds(List<Integer> conversationMessageIds) {
        return addParam("conversation_message_ids", csv(conversationMessageIds));
    }

    public GetByConversationMessageId setExtended(boolean extended) {
        return addParam("extended", extended ? 1 : 0);
    }

    public GetByConversationMessageId setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetByConversationMessageId setFields(List<String> fields) {
        return addParam("fields", csv(fields));
    }

    public GetByConversationMessageId setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetByConversationMessageId addParam(String key, Object value) {
        return (GetByConversationMessageId) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getByConversationMessageId</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<VkList<Message>> {
    }
}
