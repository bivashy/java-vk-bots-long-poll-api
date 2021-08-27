package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.searchConversations</b> method.
 * <p>
 * Returns a list of conversations that match search criteria.
 *
 * @see <a href="https://vk.com/dev/messages.searchConversations">https://vk.com/dev/messages.searchConversations</a>
 */
public class SearchConversations extends AuthorizedVkApiMethod<SearchConversations.Response> {
    public SearchConversations(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.searchConversations");
    }

    @Override
    protected Class<Response> getResultType() {
        return Response.class;
    }

    public SearchConversations setQ(String q) {
        addParam("q", q);
        return this;
    }

    public SearchConversations setCount(int count) {
        addParam("count", count);
        return this;
    }

    public SearchConversations setExtended(boolean extended) {
        addParam("extended", new
                BoolInt(extended));
        return this;
    }

    public SearchConversations setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public SearchConversations setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    public SearchConversations setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    /**
     * Response to <b>messages.searchConversations</b> request.
     */
    public static class Response extends GetConversationsById.Response {
    }
}
