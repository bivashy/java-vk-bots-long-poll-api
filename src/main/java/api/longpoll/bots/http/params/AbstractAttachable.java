package api.longpoll.bots.http.params;

/**
 * Attachment to be passed into VK API request parameters.
 */
public abstract class AbstractAttachable implements AttachableParam {
    private static final String ATTACHMENT_NO_KEY = "%s%d_%d";
    private static final String ATTACHMENT = ATTACHMENT_NO_KEY + "_%s";

    /**
     * Converts attachment data into string format:
     * {type}{owner_id}_{media_id}_{access_token}
     *
     * @param type      attachment type.
     * @param ownerId   attachment owner_id.
     * @param mediaId   attachment ID.
     * @param accessKey attachment access key.
     * @return attachment string parameter.
     */
    public String toAttachmentString(String type, int ownerId, int mediaId, String accessKey) {
        return accessKey != null
                ? String.format(ATTACHMENT, type, ownerId, mediaId, accessKey)
                : String.format(ATTACHMENT_NO_KEY, type, ownerId, mediaId);
    }
}
