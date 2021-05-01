package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>stories.hideAllReplies</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.hideAllReplies">https://vk.com/dev/stories.hideAllReplies</a>
 */
public class StoriesHideAllReplies extends GetMethod<IntegerResult> {
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
        return VkApi.getInstance().storiesHideAllReplies();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
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
