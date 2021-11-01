package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.AttachableParam;
import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
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
public class Edit extends AuthorizedVkApiMethod<IntegerResponse> {
    public Edit(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.edit");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public Edit setAttachments(AttachableParam... attachments) {
        return setAttachments(Arrays.asList(attachments));
    }

    public Edit setAttachments(List<AttachableParam> attachments) {
        return addParam("attachment", attachments);
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
        return addParam("keep_forward_messages", new BoolInt(keepForwardMessages));
    }

    public Edit setKeepSnippets(boolean keepSnippets) {
        return addParam("keep_snippets", new BoolInt(keepSnippets));
    }

    public Edit setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public Edit setDontParseLinks(boolean dontParseLinks) {
        return addParam("dont_parse_links", new BoolInt(dontParseLinks));
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
