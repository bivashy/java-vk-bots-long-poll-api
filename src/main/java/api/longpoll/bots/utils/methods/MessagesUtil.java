package api.longpoll.bots.utils.methods;

import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.methods.docs.DocsGetMessagesUploadServer;
import api.longpoll.bots.methods.docs.DocsSave;
import api.longpoll.bots.methods.upload.UploadDoc;
import api.longpoll.bots.methods.upload.UploadPhoto;
import api.longpoll.bots.methods.photos.PhotosGetMessagesUploadServer;
import api.longpoll.bots.methods.photos.PhotosSaveMessagesPhoto;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;
import api.longpoll.bots.model.response.other.UploadDocResult;
import api.longpoll.bots.model.response.other.UploadPhotoResult;
import api.longpoll.bots.model.response.photos.PhotosGetMessagesUploadServerResult;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResult;

import java.io.File;

/**
 * A helper to work with Message methods.
 */
public class MessagesUtil {
    /**
     * Uploads photo to conversation.
     *
     * @param accessToken bot access token
     * @param peerId      conversation ID
     * @param photo       photo to be uploaded
     * @return Uploaded photo info
     * @throws BotsLongPollAPIException if error occurs.
     * @throws BotsLongPollException    if error occurs.
     */
    public static PhotosSaveMessagesPhotoResult.Response uploadPhoto(String accessToken, int peerId, File photo) throws BotsLongPollAPIException, BotsLongPollException {
        PhotosGetMessagesUploadServerResult.Response uploadServer = new PhotosGetMessagesUploadServer(accessToken)
                .setPeerId(peerId)
                .execute()
                .getResponse();
        UploadPhotoResult uploadPhoto = new UploadPhoto()
                .setUploadUrl(uploadServer.getUploadUrl())
                .setFile(photo)
                .execute();
        return new PhotosSaveMessagesPhoto(accessToken)
                .setHash(uploadPhoto.getHash())
                .setPhoto(uploadPhoto.getPhoto())
                .setServer(uploadPhoto.getServer())
                .execute()
                .getResponse()
                .get(0);
    }

    /**
     * Uploads document to conversation.
     *
     * @param accessToken bot access token
     * @param peerId      conversation ID
     * @param doc         document to be uploaded
     * @return uploaded document info.
     * @throws BotsLongPollAPIException if error occurs.
     * @throws BotsLongPollException    if error occurs.
     */
    public static Doc uploadDoc(String accessToken, int peerId, File doc) throws BotsLongPollAPIException, BotsLongPollException {
        DocsGetUploadServerResult.Response uploadServer = new DocsGetMessagesUploadServer(accessToken)
                .setType("doc")
                .setPeerId(peerId)
                .execute()
                .getResponse();
        UploadDocResult uploadDoc = new UploadDoc()
                .setUploadUrl(uploadServer.getUploadUrl())
                .setFile(doc)
                .execute();
        return (Doc) new DocsSave(accessToken)
                .setFile(uploadDoc.getFile())
                .execute()
                .getResponse()
                .getAttachable();
    }
}
