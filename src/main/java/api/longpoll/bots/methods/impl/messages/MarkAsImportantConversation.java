package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.markAsImportantConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsImportantConversation">https://vk.com/dev/messages.markAsImportantConversation</a>
 */
public class MarkAsImportantConversation extends VkMethod<IntegerResponse> {
    private final Converter<Boolean, Integer> boolIntConverter = VkBotsConfig.getInstance().getBoolIntConverter();

    public MarkAsImportantConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkBotsConfig.getInstance().getBotMethods().getProperty("messages.markAsImportantConversation");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public MarkAsImportantConversation setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public MarkAsImportantConversation setAnswered(boolean answered) {
        return addParam("answered", boolIntConverter.convert(answered));
    }

    public MarkAsImportantConversation setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public MarkAsImportantConversation addParam(String key, Object value) {
        return (MarkAsImportantConversation) super.addParam(key, value);
    }
}
