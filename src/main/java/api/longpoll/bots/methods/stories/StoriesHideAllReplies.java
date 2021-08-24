package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>stories.hideAllReplies</b> method.
 *
 * Hides all replies in the last 24 hours from the user to current user's stories.
 *
 * @see <a href="https://vk.com/dev/stories.hideAllReplies">https://vk.com/dev/stories.hideAllReplies</a>
 */
public class StoriesHideAllReplies extends VkApiGetMethod<IntegerResult> {
    /**
     * ID of the user whose replies should be hidden.
     */
    private Integer ownerId;

    /**
     * Community ID.
     */
    private Integer groupId;

    public StoriesHideAllReplies(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("stories.hideAllReplies");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public StoriesHideAllReplies setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public StoriesHideAllReplies setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
