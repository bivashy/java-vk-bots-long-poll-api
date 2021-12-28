package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.converter.impl.ListConverter;
import api.longpoll.bots.converter.impl.VkAttachmentsConverter;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.VkAttachment;
import api.longpoll.bots.model.response.IntegerResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.edit</b> method.
 * <p>
 * Edits the message.
 *
 * @see <a href="https://vk.com/dev/messages.edit">https://vk.com/dev/messages.edit</a>
 */
public class Edit extends VkMethod<IntegerResponse> {
    private final Converter<List<?>, String> listConverter = new ListConverter();
    private final Converter<List<VkAttachment>, List<String>> vkAttachmentsListConverter = new VkAttachmentsConverter();

    public Edit(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("messages.edit");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public Edit setAttachments(VkAttachment... attachments) {
        return setAttachments(Arrays.asList(attachments));
    }

    public Edit setAttachments(List<VkAttachment> attachments) {
        return addParam("attachment", listConverter.convert(vkAttachmentsListConverter.convert(attachments)));
    }

    public Edit setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public Edit setMessage(String message) {
        return addParam("message", message);
    }

    public Edit setLatitude(float latitude) {
        return addParam("lat", latitude);
    }

    public Edit setLongitude(float longitude) {
        return addParam("long", longitude);
    }

    public Edit setKeepForwardMessages(boolean keepForwardMessages) {
        return addParam("keep_forward_messages", keepForwardMessages ? 1 : 0);
    }

    public Edit setKeepSnippets(boolean keepSnippets) {
        return addParam("keep_snippets", keepSnippets ? 1 : 0);
    }

    public Edit setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public Edit setDontParseLinks(boolean dontParseLinks) {
        return addParam("dont_parse_links", dontParseLinks ? 1 : 0);
    }

    public Edit setMessageId(int messageId) {
        return addParam("message_id", messageId);
    }

    public Edit setConversationMessageId(int conversationMessageId) {
        return addParam("conversation_message_id", conversationMessageId);
    }

    @Override
    public Edit addParam(String key, Object value) {
        return (Edit) super.addParam(key, value);
    }
}
