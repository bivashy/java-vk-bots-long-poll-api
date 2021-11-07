package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.model.objects.additional.VkAttachment;

import java.io.InputStream;

/**
 * Uploads document to conversation.
 * Executes:
 * <ol>
 *     <li>docs.getMessagesUploadServer</li>
 *     <li>[uploading document to VK server]</li>
 *     <li>docs.save</li>
 * </ol>
 * The result of execution can be passed as <b>messages.send</b> parameter.
 */
public class AttachDoc extends VkMethod<VkAttachment> {
    /**
     * ID of conversation.
     */
    private int peerId;

    /**
     * Document type. Possible values:
     * <ol>
     *     <li>doc - for any files.</li>
     *     <li>audio_message - for voice messages.</li>
     * </ol>
     */
    private String type;

    /**
     * Name of file.
     */
    private String filename;

    /**
     * File {@link InputStream}.
     */
    private InputStream doc;

    /**
     * Gets upload server.
     */
    private final GetMessagesUploadServer getMessagesUploadServer;

    /**
     * Upload file to VK server.
     */
    private final UploadDoc uploadDoc = VkBotsConfig.getInstance().getUploadDoc();

    /**
     * Saves uploaded document.
     */
    private final Save save;

    public AttachDoc(String accessToken) {
        super(accessToken);
        getMessagesUploadServer = VkBotsConfig.getInstance().getDocsGetMessagesUploadServerFactory().get(accessToken);
        save = VkBotsConfig.getInstance().getDocsSaveFactory().get(accessToken);
    }

    @Override
    public VkAttachment execute() throws VkApiException {
        GetMessagesUploadServer.Response uploadServer = getMessagesUploadServer
                .setPeerId(peerId)
                .setType(type)
                .execute();
        UploadDoc.Response uploadedDoc = uploadDoc
                .setUrl(uploadServer.getResponseObject().getUploadUrl())
                .setDoc(filename, doc)
                .execute();
        Save.Response savedFile = save.setFile(uploadedDoc.getFile()).execute();
        return new VkAttachment(savedFile);
    }

    public AttachDoc setPeerId(int peerId) {
        this.peerId = peerId;
        return this;
    }

    public AttachDoc setType(String type) {
        this.type = type;
        return this;
    }

    public AttachDoc setDoc(String filename, InputStream doc) {
        this.filename = filename;
        this.doc = doc;
        return this;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    protected Class<VkAttachment> getResponseType() {
        return null;
    }
}
