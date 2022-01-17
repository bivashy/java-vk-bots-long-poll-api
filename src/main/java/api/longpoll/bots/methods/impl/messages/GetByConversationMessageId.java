package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.converter.impl.ListConverter;
import api.longpoll.bots.methods.impl.VkMethod;
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
public class GetByConversationMessageId extends VkMethod<GetByConversationMessageId.Response> {
    private final Converter<List<?>, String> listConverter = new ListConverter();


    public GetByConversationMessageId(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("messages.getByConversationMessageId");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetByConversationMessageId setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public GetByConversationMessageId setConversationMessageIds(Integer... conversationMessageIds) {
        return setConversationMessageIds(Arrays.asList(conversationMessageIds));
    }

    public GetByConversationMessageId setConversationMessageIds(List<Integer> conversationMessageIds) {
        return addParam("conversation_message_ids", toCommaSeparatedValues(conversationMessageIds));
    }

    public GetByConversationMessageId setExtended(boolean extended) {
        return addParam("extended", extended ? 1 : 0);
    }

    public GetByConversationMessageId setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetByConversationMessageId setFields(List<String> fields) {
        return addParam("fields", toCommaSeparatedValues(fields));
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
    public static class Response extends GenericResponse<VkList<Message>> {
    }
}
