package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.helpers.attachments.Attachable;
import api.longpoll.bots.helpers.attachments.MessageDocAttachable;
import api.longpoll.bots.helpers.attachments.MessagePhotoAttachable;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.VkAttachment;
import api.longpoll.bots.model.response.IntegerResponse;
import api.longpoll.bots.suppliers.PeerIdSupplier;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
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
    /**
     * List of objects to attach.
     */
    private final List<Attachable> attachables = new ArrayList<>();

    /**
     * Supplies {@code peer_id}.
     */
    private final PeerIdSupplier peerIdSupplier = new PeerIdSupplier();

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

    @Override
    public IntegerResponse execute() throws VkApiException {
        List<VkAttachment> attachments = new ArrayList<>();
        for (Attachable attachable : attachables) {
            attachments.add(attachable.attach());
        }
        if (!attachments.isEmpty()) {
            setAttachment(attachments);
        }
        return super.execute();
    }

    public Edit addPhoto(File photo) {
        attachables.add(new MessagePhotoAttachable(
                photo,
                peerIdSupplier,
                getParams().get("access_token")
        ));
        return this;
    }

    public Edit addPhoto(Path photo) {
        return addPhoto(photo.toFile());
    }

    public Edit addDoc(File doc) {
        attachables.add(new MessageDocAttachable(
                doc,
                peerIdSupplier,
                getParams().get("access_token")
        ));
        return this;
    }

    public Edit addDoc(Path doc) {
        return addDoc(doc.toFile());
    }

    public Edit setAttachment(VkAttachment... vkAttachments) {
        return setAttachment(Arrays.asList(vkAttachments));
    }

    public Edit setAttachment(List<VkAttachment> vkAttachments) {
        return setAttachment(toCommaSeparatedValues(vkAttachments));
    }

    public Edit setAttachment(String attachment) {
        return addParam("attachment", attachment);
    }

    public Edit setPeerId(int peerId) {
        peerIdSupplier.setPeerId(peerId);
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
