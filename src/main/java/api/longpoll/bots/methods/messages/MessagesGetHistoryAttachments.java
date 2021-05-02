package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryAttachmentsResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.getHistoryAttachments</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getHistoryAttachments">https://vk.com/dev/messages.getHistoryAttachments</a>
 */
public class MessagesGetHistoryAttachments extends VkApiGetMethod<MessagesGetHistoryAttachmentsResult> {
    /**
     * Peer ID.
     */
    private Integer peerId;

    /**
     * Type of media files to return.
     */
    private String mediaType;

    /**
     * Message ID to start return results from.
     */
    private String startFrom;

    /**
     * Number of objects to return.
     */
    private Integer count;

    /**
     * <b>true</b> — to return photo sizes in a special format.
     */
    private Boolean photoSizes;

    /**
     * Additional profile fields to return.
     */
    private List<String> fields;

    /**
     * Group ID.
     */
    private Integer groupId;

    /**
     * Preserve order.
     */
    private Boolean preserveOrder;

    /**
     * Maximum forwards level.
     */
    private Integer maxForwardsLevel;

    public MessagesGetHistoryAttachments(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetHistoryAttachments();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("peer_id", peerId),
                param("media_type", mediaType),
                param("start_from", startFrom),
                param("count", count),
                param("photo_sizes", photoSizes, true),
                param("fields", fields),
                param("group_id", groupId),
                param("preserve_order", preserveOrder, true),
                param("max_forwards_level", maxForwardsLevel)
        );
    }

    @Override
    protected Class<? extends MessagesGetHistoryAttachmentsResult> getResultType() {
        return MessagesGetHistoryAttachmentsResult.class;
    }

    public MessagesGetHistoryAttachments setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesGetHistoryAttachments setMediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public MessagesGetHistoryAttachments setStartFrom(String startFrom) {
        this.startFrom = startFrom;
        return this;
    }

    public MessagesGetHistoryAttachments setCount(Integer count) {
        this.count = count;
        return this;
    }

    public MessagesGetHistoryAttachments setPhotoSizes(Boolean photoSizes) {
        this.photoSizes = photoSizes;
        return this;
    }

    public MessagesGetHistoryAttachments setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public MessagesGetHistoryAttachments setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public MessagesGetHistoryAttachments setPreserveOrder(Boolean preserveOrder) {
        this.preserveOrder = preserveOrder;
        return this;
    }

    public MessagesGetHistoryAttachments setMaxForwardsLevel(Integer maxForwardsLevel) {
        this.maxForwardsLevel = maxForwardsLevel;
        return this;
    }
}
