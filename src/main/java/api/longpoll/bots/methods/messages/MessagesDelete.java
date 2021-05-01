package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesDeleteResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>messages.delete</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.delete">https://vk.com/dev/messages.delete</a>
 */
public class MessagesDelete extends GetMethod<MessagesDeleteResult> {
    /**
     * Message IDs.
     */
    private List<Integer> messageIds;

    /**
     * <b>true</b> to mark message as spam.
     */
    private Boolean spam;

    /**
     * Group ID.
     */
    private Integer groupId;

    /**
     * <b>true</b> to delete message for recipient.
     */
    private Boolean deleteForAll;

    public MessagesDelete(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesDelete();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("message_ids", messageIds),
                keyVal("spam", spam, true),
                keyVal("group_id", groupId),
                keyVal("delete_for_all", deleteForAll, true)
        );
    }

    @Override
    protected Class<? extends MessagesDeleteResult> getResultType() {
        return MessagesDeleteResult.class;
    }

    public MessagesDelete setMessageIds(List<Integer> messageIds) {
        this.messageIds = messageIds;
        return this;
    }

    public MessagesDelete setSpam(Boolean spam) {
        this.spam = spam;
        return this;
    }

    public MessagesDelete setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public MessagesDelete setDeleteForAll(Boolean deleteForAll) {
        this.deleteForAll = deleteForAll;
        return this;
    }
}
