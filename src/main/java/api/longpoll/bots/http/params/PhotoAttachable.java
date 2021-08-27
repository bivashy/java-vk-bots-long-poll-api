package api.longpoll.bots.http.params;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.media.Photo;

/**
 * Photo attachment represented by {@link Photo}.
 */
public class PhotoAttachable extends AbstractAttachable {
    private Photo photo;

    public PhotoAttachable(Photo photo) {
        this.photo = photo;
    }

    @Override
    public String attach() throws VkApiException {
        return toAttachmentString("photo", photo.getOwnerId(), photo.getId(), photo.getAccessKey());
    }
}
