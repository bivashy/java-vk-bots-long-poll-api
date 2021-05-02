package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.editChat</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.editChat">https://vk.com/dev/messages.editChat</a>
 */
public class MessagesEditChat extends VkApiGetMethod<IntegerResult> {
    /**
     * Chat ID.
     */
    private Integer chatId;

    /**
     * New title of the chat.
     */
    private String title;

    public MessagesEditChat(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesEditChat();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("chat_id", chatId),
                param("title", title)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public MessagesEditChat setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public MessagesEditChat setTitle(String title) {
        this.title = title;
        return this;
    }
}
