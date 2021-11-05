package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
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
    private final Converter<Boolean, Integer> boolIntConverter = VkBotsConfig.getInstance().getBoolIntConverter();
    private final Converter<List<?>, String> listConverter = VkBotsConfig.getInstance().getListConverter();

    public SearchConversations(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.searchConversations");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public SearchConversations setQ(String q) {
        return addParam("q", q);
    }

    public SearchConversations setCount(int count) {
        return addParam("count", count);
    }

    public SearchConversations setExtended(boolean extended) {
        addParam("extended", boolIntConverter.convert(extended));
        return this;
    }

    public SearchConversations setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public SearchConversations setFields(List<String> fields) {
        return addParam("fields", listConverter.convert(fields));
    }

    public SearchConversations setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public SearchConversations addParam(String key, Object value) {
        return (SearchConversations) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.searchConversations</b> request.
     */
    public static class Response extends GetConversationsById.Response {
    }
}
