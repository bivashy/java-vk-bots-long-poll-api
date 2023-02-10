package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.helpers.attachments.UploadableDoc;
import api.longpoll.bots.helpers.attachments.UploadableFile;
import api.longpoll.bots.helpers.attachments.UploadableFilesSupplier;
import api.longpoll.bots.helpers.attachments.UploadablePhoto;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.Template;
import api.longpoll.bots.model.objects.additional.UploadedFile;
import api.longpoll.bots.model.response.IntegerResponseBody;
import api.longpoll.bots.utils.ParamUtils;
import api.longpoll.bots.utils.VkMethods;
import com.google.gson.Gson;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Implements <b>messages.edit</b> method.
 * <p>
 * Edits the message.
 *
 * @see <a href="https://vk.com/dev/messages.edit">https://vk.com/dev/messages.edit</a>
 */
public class Edit extends VkMethod<IntegerResponseBody> {
    private final Gson gson = new Gson();
    private final String accessToken;
    private final UploadableFilesSupplier uploadableFilesSupplier = new UploadableFilesSupplier();

    public Edit(String accessToken) {
        super(VkMethods.get("messages.edit"), accessToken);
        this.accessToken = accessToken;
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
    }

    @Override
    public IntegerResponseBody execute() throws VkApiException {
        List<UploadedFile> attachments = new ArrayList<>();
        for (UploadableFile uploadableFile : uploadableFilesSupplier.get()) {
            attachments.add(uploadableFile.upload());
        }
        if (!attachments.isEmpty()) {
            setAttachment(attachments);
        }
        return super.execute();
    }

    @Override
    public CompletableFuture<IntegerResponseBody> executeAsync() {
        List<CompletableFuture<UploadedFile>> uploadedFiles = new ArrayList<>();
        for (UploadableFile uploadableFile : uploadableFilesSupplier.get()) {
            uploadedFiles.add(uploadableFile.uploadAsync());
        }
        return CompletableFuture.allOf(uploadedFiles.toArray(new CompletableFuture[0]))
                .thenApply(unused -> uploadedFiles.stream().map(CompletableFuture::join).collect(Collectors.toList()))
                .thenCompose(attachments -> {
                    if (!attachments.isEmpty()) {
                        setAttachment(attachments);
                    }
                    return super.executeAsync();
                });
    }

    public Edit addPhoto(File photo) {
        uploadableFilesSupplier.addUploadbleFileFactory(peerId -> new UploadablePhoto(
                accessToken,
                peerId,
                uploadUrl -> new UploadPhoto(uploadUrl, photo)
        ));
        return this;
    }

    public Edit addPhoto(Path photo) {
        uploadableFilesSupplier.addUploadbleFileFactory(peerId -> new UploadablePhoto(
                accessToken,
                peerId,
                uploadUrl -> new UploadPhoto(uploadUrl, photo)
        ));
        return this;
    }

    public Edit addPhoto(String filename, InputStream photo) {
        uploadableFilesSupplier.addUploadbleFileFactory(peerId -> new UploadablePhoto(
                accessToken,
                peerId,
                uploadUrl -> new UploadPhoto(uploadUrl, filename, photo)
        ));
        return this;
    }

    public Edit addPhoto(String filename, byte[] photo) {
        uploadableFilesSupplier.addUploadbleFileFactory(peerId -> new UploadablePhoto(
                accessToken,
                peerId,
                uploadUrl -> new UploadPhoto(uploadUrl, filename, photo)
        ));
        return this;
    }

    public Edit addDoc(File doc) {
        uploadableFilesSupplier.addUploadbleFileFactory(peerId -> new UploadableDoc(
                accessToken,
                peerId,
                uploadUrl -> new UploadDoc(uploadUrl, doc)
        ));
        return this;
    }

    public Edit addDoc(Path doc) {
        uploadableFilesSupplier.addUploadbleFileFactory(peerId -> new UploadableDoc(
                accessToken,
                peerId,
                uploadUrl -> new UploadDoc(uploadUrl, doc)
        ));
        return this;
    }

    public Edit addDoc(String filename, InputStream doc) {
        uploadableFilesSupplier.addUploadbleFileFactory(peerId -> new UploadableDoc(
                accessToken,
                peerId,
                uploadUrl -> new UploadDoc(uploadUrl, filename, doc)
        ));
        return this;
    }

    public Edit addDoc(String filename, byte[] doc) {
        uploadableFilesSupplier.addUploadbleFileFactory(peerId -> new UploadableDoc(
                accessToken,
                peerId,
                uploadUrl -> new UploadDoc(uploadUrl, filename, doc)
        ));
        return this;
    }

    public Edit setAttachment(UploadedFile... uploadedFiles) {
        return setAttachment(Arrays.asList(uploadedFiles));
    }

    public Edit setAttachment(List<UploadedFile> uploadedFiles) {
        return setAttachment(ParamUtils.csv(uploadedFiles));
    }

    public Edit setAttachment(String attachment) {
        return addParam("attachment", attachment);
    }

    public Edit setPeerId(int peerId) {
        uploadableFilesSupplier.addPeerId(peerId);
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
        return addParam("template", gson.toJson(template));
    }

    public Edit setDisableMentions(boolean disableMentions) {
        return addParam("disable_mentions", disableMentions ? 1 : 0);
    }

    @Override
    public Edit addParam(String key, Object value) {
        return (Edit) super.addParam(key, value);
    }
}
