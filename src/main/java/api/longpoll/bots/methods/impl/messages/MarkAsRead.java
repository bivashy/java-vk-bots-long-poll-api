package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.markAsRead</b> method.
 * <p>
 * Marks messages as read.
 *
 * @see <a href="https://vk.com/dev/messages.markAsRead">https://vk.com/dev/messages.markAsRead</a>
 */
public class MarkAsRead extends VkMethod<IntegerResponse> {
    private final Converter<Boolean, Integer> boolIntConverter = VkBotsConfig.getInstance().getBoolIntConverter();

    public MarkAsRead(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkApiProperties.get("messages.markAsRead");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public MarkAsRead setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public MarkAsRead setStartMessageId(int startMessageId) {
        return addParam("start_message_id", startMessageId);
    }

    public MarkAsRead setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public MarkAsRead setMarkConversationAsRead(boolean markConversationAsRead) {
        return addParam("mark_conversation_as_read", boolIntConverter.convert(markConversationAsRead));
    }

    @Override
    public MarkAsRead addParam(String key, Object value) {
        return (MarkAsRead) super.addParam(key, value);
    }
}
