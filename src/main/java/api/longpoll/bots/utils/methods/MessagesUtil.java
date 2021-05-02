package api.longpoll.bots.utils.methods;

import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.methods.docs.DocsGetMessagesUploadServer;
import api.longpoll.bots.methods.docs.DocsSave;
import api.longpoll.bots.methods.other.UploadDoc;
import api.longpoll.bots.methods.other.UploadPhoto;
import api.longpoll.bots.methods.photos.PhotosGetMessagesUploadServer;
import api.longpoll.bots.methods.photos.PhotosSaveMessagesPhoto;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;
import api.longpoll.bots.model.response.other.UploadDocResult;
import api.longpoll.bots.model.response.other.UploadPhotoResult;
import api.longpoll.bots.model.response.photos.PhotosGetMessagesUploadServerResult;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResult;

import java.io.File;

public class MessagesUtil {
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
