package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.model.objects.additional.UploadedFile;
import api.longpoll.bots.model.objects.media.Doc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.function.Supplier;

/**
 * Uploads a document to VK server.
 */
public class UploadableMessageDoc implements UploadableFile {
    /**
     * Doc to upload.
     */
    private final File doc;

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

    public UploadableMessageDoc(File doc, Supplier<Integer> peerIdSupplier, String accessToken) {
        this.doc = doc;
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerIdSupplier.get()).setType("doc");
        this.uploadDoc = new UploadDoc();
        this.save = new Save(accessToken);
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        try (InputStream inputStream = Files.newInputStream(doc.toPath())) {
            GetMessagesUploadServer.Response uploadServer = getMessagesUploadServer.execute();
            UploadDoc.Response uploadedDoc = uploadDoc
                    .setDoc(doc.getName(), inputStream)
                    .setUrl(uploadServer.getResponseObject().getUploadUrl())
                    .execute();
            Save.Response savedFile = save.setFile(uploadedDoc.getFile()).execute();
            Doc doc = savedFile.getResponseObject().getDoc();
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
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }
}
