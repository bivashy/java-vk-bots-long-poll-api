package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.createChat</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.createChat">https://vk.com/dev/messages.createChat</a>
 */
public class MessagesCreateChat extends VkApiGetMethod<IntegerResult> {
    /**
     * IDs of the users to be added to the chat.
     */
    private List<Integer> userIds;

    /**
     * Chat title.
     */
    private String title;

    /**
     * Community ID.
     */
    private Integer groupId;

    public MessagesCreateChat(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesCreateChat();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("user_ids", userIds),
                param("title", title),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public MessagesCreateChat setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }

    public MessagesCreateChat setTitle(String title) {
        this.title = title;
        return this;
    }

    public MessagesCreateChat setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
