package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.setSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.setSettings">https://vk.com/dev/groups.setSettings</a>
 */
public class SetSettings extends AuthorizedVkApiMethod<IntegerResponse> {
    public SetSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.setSettings");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public SetSettings setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public SetSettings setMessages(boolean messages) {
        addParam("messages", new BoolInt(messages));
        return this;
    }

    public SetSettings setBotsCapabilities(boolean botsCapabilities) {
        addParam("bots_capabilities", new BoolInt(botsCapabilities));
        return this;
    }

    public SetSettings setBotsAddToChat(boolean botsAddToChat) {
        addParam("bots_add_to_chat", new BoolInt(botsAddToChat));
        return this;
    }
}
