package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.model.objects.additional.UploadedFile;
import api.longpoll.bots.model.objects.media.Doc;

import java.io.InputStream;

/**
 * Uploads a document to message.
 */
public abstract class UploadableMessageDoc extends AbstractUploadableFile {
    /**
     * Gets an upload server.
     */
    private final GetMessagesUploadServer getMessagesUploadServer;

    /**
     * Saves a document.
     */
    private final Save save;

    public UploadableMessageDoc(Integer peerId, String accessToken) {
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerId).setType("doc");
        this.save = new Save(accessToken);
    }

    @Override
    public UploadedFile uploadFile(String filename, InputStream inputStream) throws VkApiException {
        GetMessagesUploadServer.ResponseBody uploadServer = getMessagesUploadServer.execute();
        UploadDoc.ResponseBody uploadedDoc = new UploadDoc(
                uploadServer.getResponse().getUploadUrl(),
                filename,
                inputStream
        ).execute();

        Save.ResponseBody savedFile = save.setFile(uploadedDoc.getFile()).execute();
        Doc doc = savedFile.getResponse().getDoc();
        return new UploadedFile(
                "doc",
                doc.getOwnerId(),
                doc.getId(),
                doc.getAccessKey()
        );
    }
}
