package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>stories.hideAllReplies</b> method.
 * <p>
 * Hides all replies in the last 24 hours from the user to current user's stories.
 *
 * @see <a href="https://vk.com/dev/stories.hideAllReplies">https://vk.com/dev/stories.hideAllReplies</a>
 */
public class HideAllReplies extends VkMethod<IntegerResponseBody> {
    public HideAllReplies(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("stories.hideAllReplies");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
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
