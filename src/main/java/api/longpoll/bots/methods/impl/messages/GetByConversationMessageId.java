package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.GenericResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getByConversationMessageId</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getByConversationMessageId">https://vk.com/dev/messages.getByConversationMessageId</a>
 */
public class GetByConversationMessageId extends AuthorizedVkApiMethod<GetByConversationMessageId.Response> {
    public GetByConversationMessageId(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.getByConversationMessageId");
    }

    @Override
    protected Class<Response> getResultType() {
        return Response.class;
    }

    public GetByConversationMessageId setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public GetByConversationMessageId setConversationMessageIds(Integer... conversationMessageIds) {
        return setConversationMessageIds(Arrays.asList(conversationMessageIds));
    }

    public GetByConversationMessageId setConversationMessageIds(List<Integer> conversationMessageIds) {
        addParam("conversation_message_ids", conversationMessageIds);
        return this;
    }

    public GetByConversationMessageId setExtended(boolean extended) {
        addParam("extended", new BoolInt(extended));
        return this;
    }

    public GetByConversationMessageId setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetByConversationMessageId setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    public GetByConversationMessageId setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    /**
     * Response to <b>messages.getByConversationMessageId</b> request.
     */
    public static class Response extends GenericResponse<VkList<Message>> {
    }
}
