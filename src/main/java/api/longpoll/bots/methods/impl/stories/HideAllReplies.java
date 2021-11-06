package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>stories.hideAllReplies</b> method.
 * <p>
 * Hides all replies in the last 24 hours from the user to current user's stories.
 *
 * @see <a href="https://vk.com/dev/stories.hideAllReplies">https://vk.com/dev/stories.hideAllReplies</a>
 */
public class HideAllReplies extends VkMethod<IntegerResponse> {
    public HideAllReplies(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkBotsConfig.getInstance().getBotMethods().getProperty("stories.hideAllReplies");
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
