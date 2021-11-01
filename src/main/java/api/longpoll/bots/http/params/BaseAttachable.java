package api.longpoll.bots.http.params;

/**
 * Attachment to be passed into VK API request parameters.
 */
public class BaseAttachable implements AttachableParam {
    private static final String ATTACHMENT_NO_KEY = "%s%d_%d";
    private static final String ATTACHMENT = ATTACHMENT_NO_KEY + "_%s";
    private final String attachment;

    public BaseAttachable(String attachment) {
        this.attachment = attachment;
    }

    public BaseAttachable(String type, int ownerId, int mediaId, String accessKey) {
        this(toAttachmentString(type, ownerId, mediaId, accessKey));
    }

    public BaseAttachable(String type, int ownerId, int mediaId) {
        this(type, ownerId, mediaId, null);
    }

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
    protected static String toAttachmentString(String type, int ownerId, int mediaId, String accessKey) {
        return accessKey != null
                ? String.format(ATTACHMENT, type, ownerId, mediaId, accessKey)
                : String.format(ATTACHMENT_NO_KEY, type, ownerId, mediaId);
    }

    @Override
    public String attach() {
        return attachment;
    }
}
