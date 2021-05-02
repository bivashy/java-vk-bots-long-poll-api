package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.restore</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.restore">https://vk.com/dev/messages.restore</a>
 */
public class MessagesRestore extends VkApiGetMethod<IntegerResult> {
    /**
     * ID of a previously-deleted message to restore.
     */
    private Integer messageId;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesRestore(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesRestore();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("message_id", messageId),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public MessagesRestore setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public MessagesRestore setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
