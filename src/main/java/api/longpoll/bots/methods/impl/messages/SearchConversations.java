package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.utils.ParamUtils;
import api.longpoll.bots.utils.VkMethods;

import java.util.Arrays;

/**
 * Implements <b>messages.searchConversations</b> method.
 * <p>
 * Returns a list of conversations that match search criteria.
 *
 * @see <a href="https://vk.com/dev/messages.searchConversations">https://vk.com/dev/messages.searchConversations</a>
 */
public class SearchConversations extends VkMethod<SearchConversations.ResponseBody> {
    public SearchConversations(String accessToken) {
        super(VkMethods.get("messages.searchConversations"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public SearchConversations setQ(String q) {
        return addParam("q", q);
    }

    public SearchConversations setCount(int count) {
        return addParam("count", count);
    }

    public SearchConversations setExtended(boolean extended) {
        addParam("extended", extended ? 1 : 0);
        return this;
    }

    public SearchConversations setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public SearchConversations setFields(Iterable<String> fields) {
        return addParam("fields", ParamUtils.csv(fields));
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
    public static class ResponseBody extends GetConversationsById.ResponseBody {
    }
}
