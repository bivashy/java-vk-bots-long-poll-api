package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.model.objects.additional.UploadedFile;
import api.longpoll.bots.model.objects.media.Doc;

import java.io.InputStream;
import java.util.function.Supplier;

/**
 * Uploads a document to message.
 */
public abstract class UploadableMessageDoc extends AbstractUploadableFile {
    /**
     * Gets an upload server.
     */
    private final GetMessagesUploadServer getMessagesUploadServer;

    /**
     * Uploads a document to VK server.
     */
    private final UploadDoc uploadDoc;

    /**
     * Saves a document.
     */
    private final Save save;

    public UploadableMessageDoc(Supplier<Integer> peerIdSupplier, String accessToken) {
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerIdSupplier.get()).setType("doc");
        this.uploadDoc = new UploadDoc();
        this.save = new Save(accessToken);
    }

    @Override
    public UploadedFile uploadFile(String filename, InputStream inputStream) throws VkApiException {
        GetMessagesUploadServer.ResponseBody uploadServer = getMessagesUploadServer.execute();
        UploadDoc.Response uploadedDoc = uploadDoc
                .setDoc(filename, inputStream)
                .setUrl(uploadServer.getResponse().getUploadUrl())
                .execute();
        Save.ResponseBody savedFile = save.setFile(uploadedDoc.getFile()).execute();
        Doc doc = savedFile.getResponse().getDoc();
        return new UploadedFile() {
            @Override
            public String getType() {
                return "doc";
            }

            @Override
            public int getOwnerId() {
                return doc.getOwnerId();
            }

            @Override
            public int getMediaId() {
                return doc.getId();
            }

            @Override
            public String getAccessKey() {
                return doc.getAccessKey();
            }
        };
    }
}