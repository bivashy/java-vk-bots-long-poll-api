package api.longpoll.bots.utils.methods;

import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResult;

public class AttachmentsUtil {
    public static String toAttachment(PhotosSaveMessagesPhotoResult.Response savePhoto) {
        return toAttachment("photo", savePhoto.getOwnerId(), savePhoto.getId(), savePhoto.getAccessKey());
    }

    public static String toAttachment(Photo photo) {
        return toAttachment("photo", photo.getOwnerId(), photo.getId(), photo.getAccessKey());
    }

    public static String toAttachment(Doc doc) {
        return toAttachment("doc", doc.getOwnerId(), doc.getId(), doc.getAccessKey());
    }

    private static String toAttachment(String type, Integer ownerId, Integer mediaId, String accessKey) {
        return type + ownerId + "_" + mediaId + (accessKey == null ? "" : "_" + accessKey);
    }
}
