package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesDeleteChatPhotoResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.deleteChatPhoto</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.deleteChatPhoto">https://vk.com/dev/messages.deleteChatPhoto</a>
 */
public class MessagesDeleteChatPhoto extends VkApiGetMethod<MessagesDeleteChatPhotoResult> {
    /**
     * Chat ID.
     */
    private Integer chatId;

    /**
     * Community ID.
     */
    private Integer groupId;

    public MessagesDeleteChatPhoto(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesDeleteChatPhoto();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("chat_id", chatId),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesDeleteChatPhotoResult> getResultType() {
        return MessagesDeleteChatPhotoResult.class;
    }

    public MessagesDeleteChatPhoto setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public MessagesDeleteChatPhoto setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
