package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getConversations</b> method.
 * <p>
 * Returns a list of conversations.
 *
 * @see <a href="https://vk.com/dev/messages.getConversations">https://vk.com/dev/messages.getConversations</a>
 */
public class GetConversations extends AuthorizedVkApiMethod<GetConversations.Response> {
    public GetConversations(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.getConversations");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetConversations setOffset(int offset) {
        addParam("offset", offset);
        return this;
    }

    public GetConversations setCount(int count) {
        addParam("count", count);
        return this;
    }

    public GetConversations setFilter(String filter) {
        addParam("filter", filter);
        return this;
    }

    public GetConversations setExtended(boolean extended) {
        addParam("extended", new BoolInt(extended));
        return this;
    }

    public GetConversations setStartMessageId(int startMessageId) {
        addParam("start_message_id", startMessageId);
        return this;
    }

    public GetConversations setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetConversations setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    public GetConversations setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    /**
     * Response to <b>messages.getConversations</b> request.
     */
    public static class Response extends GetConversationsById.Response {
    }
}
