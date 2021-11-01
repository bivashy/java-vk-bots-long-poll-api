package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>stories.hideAllReplies</b> method.
 * <p>
 * Hides all replies in the last 24 hours from the user to current user's stories.
 *
 * @see <a href="https://vk.com/dev/stories.hideAllReplies">https://vk.com/dev/stories.hideAllReplies</a>
 */
public class HideAllReplies extends AuthorizedVkApiMethod<IntegerResponse> {
    public HideAllReplies(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.hideAllReplies");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public HideAllReplies setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public HideAllReplies setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public HideAllReplies addParam(String key, Object value) {
        return (HideAllReplies) super.addParam(key, value);
    }
}
