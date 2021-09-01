package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getById</b> method.
 * <p>
 * Returns messages by their IDs.
 *
 * @see <a href="https://vk.com/dev/messages.getById">https://vk.com/dev/messages.getById</a>
 */
public class GetById extends AuthorizedVkApiMethod<GetById.Response> {
    public GetById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.getById");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetById setMessageIds(Integer... messageIds) {
        return setMessageIds(Arrays.asList(messageIds));
    }

    public GetById setMessageIds(List<Integer> messageIds) {
        addParam("message_ids", messageIds);
        return this;
    }

    public GetById setPreviewLength(int previewLength) {
        addParam("preview_length", previewLength);
        return this;
    }

    public GetById setExtended(boolean extended) {
        addParam("extended", new BoolInt(extended));
        return this;
    }

    public GetById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetById setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    public GetById setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    /**
     * Response to <b>messages.getById</b> request.
     */
    public static class Response extends GetByConversationMessageId.Response {
    }
}
