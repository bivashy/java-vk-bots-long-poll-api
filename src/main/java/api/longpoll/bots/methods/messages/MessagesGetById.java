package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetByIdResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>messages.getById</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getById">https://vk.com/dev/messages.getById</a>
 */
public class MessagesGetById extends GetMethod<MessagesGetByIdResult> {
    /**
     * Message IDs.
     */
    private List<Integer> messageIds;

    /**
     * Number of characters after which to truncate a previewed message.
     */
    private Integer previewLength;

    /**
     * Extended.
     */
    private Boolean extended;

    /**
     * Additional field.
     */
    private List<String> fields;

    /**
     * Community ID.
     */
    private Integer groupId;

    public MessagesGetById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetById();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("message_ids", messageIds),
                keyVal("preview_length", previewLength),
                keyVal("extended", extended, true),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesGetByIdResult> getResultType() {
        return MessagesGetByIdResult.class;
    }

    public List<Integer> getMessageIds() {
        return messageIds;
    }

    public MessagesGetById setMessageIds(List<Integer> messageIds) {
        this.messageIds = messageIds;
        return this;
    }

    public Integer getPreviewLength() {
        return previewLength;
    }

    public MessagesGetById setPreviewLength(Integer previewLength) {
        this.previewLength = previewLength;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public MessagesGetById setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetById setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
