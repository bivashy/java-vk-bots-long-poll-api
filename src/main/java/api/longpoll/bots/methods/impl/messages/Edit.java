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
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public Edit setAttachments(AttachableParam... attachments) {
        return setAttachments(Arrays.asList(attachments));
    }

    public Edit setAttachments(List<AttachableParam> attachments) {
        addParam("attachment", attachments);
        return this;
    }

    public Edit setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public Edit setMessage(String message) {
        addParam("message", message);
        return this;
    }

    public Edit setLatitude(float latitude) {
        addParam("lat", latitude);
        return this;
    }

    public Edit setLongitude(float longitude) {
        addParam("long", longitude);
        return this;
    }

    public Edit setKeepForwardMessages(boolean keepForwardMessages) {
        addParam("keep_forward_messages", new BoolInt(keepForwardMessages));
        return this;
    }

    public Edit setKeepSnippets(boolean keepSnippets) {
        addParam("keep_snippets", new BoolInt(keepSnippets));
        return this;
    }

    public Edit setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public Edit setDontParseLinks(boolean dontParseLinks) {
        addParam("dont_parse_links", new BoolInt(dontParseLinks));
        return this;
    }

    public Edit setMessageId(int messageId) {
        addParam("message_id", messageId);
        return this;
    }

    public Edit setConversationMessageId(int conversationMessageId) {
        addParam("conversation_message_id", conversationMessageId);
        return this;
    }
}
