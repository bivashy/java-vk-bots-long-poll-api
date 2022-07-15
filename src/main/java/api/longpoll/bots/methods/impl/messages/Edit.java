package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.helpers.attachments.UploadableMessageDoc;
import api.longpoll.bots.helpers.attachments.UploadableMessagePhoto;
import api.longpoll.bots.helpers.attachments.UploadableFile;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.Template;
import api.longpoll.bots.model.objects.additional.UploadedFile;
import api.longpoll.bots.model.response.IntegerResponseBody;
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
public class Edit extends VkMethod<IntegerResponseBody> {
    /**
     * List of objects to attach.
     */
    private final List<UploadableFile> uploadableFiles = new ArrayList<>();

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
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
    }

    @Override
    public IntegerResponseBody execute() throws VkApiException {
        List<UploadedFile> attachments = new ArrayList<>();
        for (UploadableFile uploadableFile : uploadableFiles) {
            attachments.add(uploadableFile.upload());
        }
        if (!attachments.isEmpty()) {
            setAttachment(attachments);
        }
        return super.execute();
    }

    public Edit addPhoto(File photo) {
        uploadableFiles.add(new UploadableMessagePhoto(
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
        uploadableFiles.add(new UploadableMessageDoc(
                doc,
                peerIdSupplier,
                getParams().get("access_token")
        ));
        return this;
    }

    public Edit addDoc(Path doc) {
        return addDoc(doc.toFile());
    }

    public Edit setAttachment(UploadedFile... uploadedFiles) {
        return setAttachment(Arrays.asList(uploadedFiles));
    }

    public Edit setAttachment(List<UploadedFile> uploadedFiles) {
        return setAttachment(toCommaSeparatedValues(uploadedFiles));
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

    public Edit setKeyboard(Keyboard keyboard) {
        return addParam("keyboard", keyboard);
    }

    public Edit setTemplate(Template template) {
        return addParam("template", getGson().toJson(template));
    }

    public Edit setDisableMentions(boolean disableMentions) {
        return addParam("disable_mentions", disableMentions ? 1 : 0);
    }

    @Override
    public Edit addParam(String key, Object value) {
        return (Edit) super.addParam(key, value);
    }
}
