package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.stories.StoriesGetViewersResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>messages.getById</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getById">https://vk.com/dev/messages.getById</a>
 */
public class StoriesGetViewers extends VkApiGetMethod<StoriesGetViewersResult> {
    /**
     * Message IDs.
     */
    private List<Integer> messageIds;

    /**
     * Number of characters after which to truncate a previewed message.
     */
    private Integer previewLength;

    /**
     * To return users.
     */
    private Boolean extended;

    /**
     * Additional fields.
     */
    private List<String> fields;

    /**
     * Group ID.
     */
    private Integer groupId;

    public StoriesGetViewers(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGetViewers();
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
    protected Class<? extends StoriesGetViewersResult> getResultType() {
        return StoriesGetViewersResult.class;
    }

    public StoriesGetViewers setMessageIds(List<Integer> messageIds) {
        this.messageIds = messageIds;
        return this;
    }

    public StoriesGetViewers setPreviewLength(Integer previewLength) {
        this.previewLength = previewLength;
        return this;
    }

    public StoriesGetViewers setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public StoriesGetViewers setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public StoriesGetViewers setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
