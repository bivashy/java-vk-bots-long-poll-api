package api.longpoll.bots.utils.methods;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.methods.docs.DocsGetMessagesUploadServer;
import api.longpoll.bots.methods.docs.DocsSave;
import api.longpoll.bots.methods.other.UploadDoc;
import api.longpoll.bots.methods.other.UploadPhoto;
import api.longpoll.bots.methods.photos.PhotosGetMessagesUploadServer;
import api.longpoll.bots.methods.photos.PhotosSaveMessagesPhoto;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResponse;
import api.longpoll.bots.model.response.other.UploadDocResult;
import api.longpoll.bots.model.response.other.UploadPhotoResult;
import api.longpoll.bots.model.response.photos.PhotosGetMessagesUploadServerResponse;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResponse;

import java.io.File;

public class MessagesUtil {
    public static PhotosSaveMessagesPhotoResponse uploadPhoto(LongPollBot bot, int peerId, File photo) throws BotsLongPollAPIException, BotsLongPollException {
        PhotosGetMessagesUploadServerResponse uploadServer = new PhotosGetMessagesUploadServer(bot)
                .setPeerId(peerId)
                .execute()
                .getResponse();
        UploadPhotoResult uploadPhoto = new UploadPhoto()
                .setUploadUrl(uploadServer.getUploadUrl())
                .setPhoto(photo)
                .execute();
        return new PhotosSaveMessagesPhoto(bot)
                .setHash(uploadPhoto.getHash())
                .setPhoto(uploadPhoto.getPhoto())
                .setServer(uploadPhoto.getServer())
                .execute()
                .getResponse()
                .get(0);
    }

    public static Doc uploadDoc(LongPollBot bot, int peerId, File doc) throws BotsLongPollAPIException, BotsLongPollException {
        DocsGetUploadServerResponse uploadServer = new DocsGetMessagesUploadServer(bot)
                .setType("doc")
                .setPeerId(peerId)
                .execute()
                .getResponse();
        UploadDocResult uploadDoc = new UploadDoc()
                .setUploadUrl(uploadServer.getUploadUrl())
                .setDoc(doc)
                .execute();
        return (Doc) new DocsSave(bot)
                .setFile(uploadDoc.getFile())
                .execute()
                .getResponse()
                .getAttachable();
    }
}
