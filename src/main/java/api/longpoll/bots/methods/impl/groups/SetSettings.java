package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.setSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.setSettings">https://vk.com/dev/groups.setSettings</a>
 */
public class SetSettings extends AuthorizedVkApiMethod<IntegerResponse> {
    private final Converter<Boolean, Integer> boolIntConverter = VkBotsConfig.getInstance().getBoolIntConverter();

    public SetSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkApiProperties.get("groups.setSettings");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public SetSettings setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public SetSettings setMessages(boolean messages) {
        return addParam("messages", boolIntConverter.convert(messages));
    }

    public SetSettings setBotsCapabilities(boolean botsCapabilities) {
        return addParam("bots_capabilities", boolIntConverter.convert(botsCapabilities));
    }

    public SetSettings setBotsAddToChat(boolean botsAddToChat) {
        return addParam("bots_add_to_chat", boolIntConverter.convert(botsAddToChat));
    }

    @Override
    public SetSettings addParam(String key, Object value) {
        return (SetSettings) super.addParam(key, value);
    }
}
