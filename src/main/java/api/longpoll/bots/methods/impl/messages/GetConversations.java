package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
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
    private final Converter<Boolean, Integer> boolIntConverter = VkBotsConfig.getInstance().getBoolIntConverter();
    private final Converter<List<?>, String> listConverter = VkBotsConfig.getInstance().getListConverter();

    public GetConversations(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkApiProperties.get("messages.getConversations");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetConversations setOffset(int offset) {
        return addParam("offset", offset);
    }

    public GetConversations setCount(int count) {
        return addParam("count", count);
    }

    public GetConversations setFilter(String filter) {
        return addParam("filter", filter);
    }

    public GetConversations setExtended(boolean extended) {
        return addParam("extended", boolIntConverter.convert(extended));
    }

    public GetConversations setStartMessageId(int startMessageId) {
        return addParam("start_message_id", startMessageId);
    }

    public GetConversations setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetConversations setFields(List<String> fields) {
        return addParam("fields", listConverter.convert(fields));
    }

    public GetConversations setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetConversations addParam(String key, Object value) {
        return (GetConversations) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getConversations</b> request.
     */
    public static class Response extends GetConversationsById.Response {
    }
}
