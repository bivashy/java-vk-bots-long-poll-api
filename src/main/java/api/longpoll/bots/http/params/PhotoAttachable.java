package api.longpoll.bots.http.params;

import api.longpoll.bots.model.objects.media.Photo;

/**
 * Photo attachment represented by {@link Photo}.
 */
public class PhotoAttachable extends BaseAttachable {
    public PhotoAttachable(Photo photo) {
        super("photo", photo.getOwnerId(), photo.getId(), photo.getAccessKey());
    }
}
