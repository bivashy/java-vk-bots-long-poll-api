package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.model.objects.additional.VkAttachment;

import java.io.InputStream;

public class AttachDoc extends VkMethod<VkAttachment> {
    private int peerId;
    private String type;
    private String filename;
    private InputStream doc;
    private final GetMessagesUploadServer getMessagesUploadServer;
    private final UploadDoc uploadDoc = VkBotsConfig.getInstance().getUploadDoc();
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
