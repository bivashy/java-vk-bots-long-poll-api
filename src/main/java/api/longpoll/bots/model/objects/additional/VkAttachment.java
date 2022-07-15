package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;

/**
 * VK attachment wrapper.
 */
public class VkAttachment {
    /**
     * Attachment type.
     */
    private final String type;

    /**
     * Attachment owner ID.
     */
    private final int ownerId;

    /**
     * Attachment ID.
     */
    private final int mediaId;

    /**
     * Attachment <i>access_key</i>.
     */
    private final String accessKey;

    public VkAttachment(String type, int ownerId, int mediaId) {
        this(type, ownerId, mediaId, null);
    }

    public VkAttachment(String type, int ownerId, int mediaId, String accessKey) {
        this.type = type;
        this.ownerId = ownerId;
        this.mediaId = mediaId;
        this.accessKey = accessKey;
    }

    public VkAttachment(Photo photo) {
        this("photo", photo.getOwnerId(), photo.getId(), photo.getAccessKey());
    }

    public VkAttachment(SaveMessagesPhoto.Response response) {
        this(
                "photo",
                response.getResponseObject().get(0).getOwnerId(),
                response.getResponseObject().get(0).getId(),
                response.getResponseObject().get(0).getAccessKey()
        );
    }

    public VkAttachment(Doc doc) {
        this("doc", doc.getOwnerId(), doc.getId(), doc.getAccessKey());
    }

    public VkAttachment(Save.Response response) {
        this(response.getResponseObject().getDoc());
    }

    public String getType() {
        return type;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    @Override
    public String toString() {
        return type + ownerId + "_" + mediaId + (accessKey != null ? "_" + accessKey : "");
    }
}
