package api.longpoll.bots.http.params;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.model.objects.media.Doc;

import java.io.File;

/**
 * Document attachment represented by {@link File}. Can be attached to messages.
 */
public class MessageDoc implements AttachableParam {
    private final String accessToken;
    private final int peerId;
    private final File doc;

    public MessageDoc(String accessToken, int peerId, File doc) {
        this.accessToken = accessToken;
        this.peerId = peerId;
        this.doc = doc;
    }

    @Override
    public String attach() throws VkApiException {
        return new DocAttachable((Doc) uploadDoc().getResponseObject().getAttachable()).attach();
    }

    private Save.Response uploadDoc() throws VkApiException {
        String uploadUrl = new GetMessagesUploadServer(accessToken)
                .setType("doc")
                .setPeerId(peerId)
                .execute()
                .getResponseObject()
                .getUploadUrl();
        String file = new UploadDoc()
                .setUploadUrl(uploadUrl)
                .setFile(doc)
                .execute()
                .getFile();
        return new Save(accessToken)
                .setFile(file)
                .execute();
    }
}
