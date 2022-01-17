package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.model.objects.additional.VkAttachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Attaches document to message.
 */
public class MessageDocAttachable implements Attachable {
    /**
     * Doc to upload.
     */
    private final File doc;

    /**
     * Gets upload server.
     */
    private final GetMessagesUploadServer getMessagesUploadServer;

    /**
     * Uploads document to VK.
     */
    private final UploadDoc uploadDoc;

    /**
     * Saves document.
     */
    private final Save save;

    public MessageDocAttachable(File doc, int peerId, String accessToken) {
        this.doc = doc;
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerId).setType("doc");
        this.uploadDoc = new UploadDoc();
        this.save = new Save(accessToken);
    }

    @Override
    public VkAttachment attach() throws VkApiException {
        try (InputStream inputStream = new FileInputStream(doc)) {
            GetMessagesUploadServer.Response uploadServer = getMessagesUploadServer.execute();
            UploadDoc.Response uploadedDoc = uploadDoc
                    .setDoc(doc.getName(), inputStream)
                    .setUrl(uploadServer.getResponseObject().getUploadUrl())
                    .execute();
            Save.Response savedFile = save.setFile(uploadedDoc.getFile()).execute();
            return new VkAttachment(savedFile);
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }
}
