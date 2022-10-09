package api.longpoll.bots.model.objects.additional;

/**
 * An uploaded to VK server file.
 */
public class UploadedFile {
    /**
     * File type.
     */
    private final String type;

    /**
     * Owner ID.
     */
    private final int ownerId;

    /**
     * File ID.
     */
    private final int mediaId;

    /**
     * file <i>access_key</i>.
     */
    private final String accessKey;

    public UploadedFile(String type, int ownerId, int mediaId, String accessKey) {
        this.type = type;
        this.ownerId = ownerId;
        this.mediaId = mediaId;
        this.accessKey = accessKey;
    }

    /**
     * Gets file type.
     *
     * @return file type.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets owner ID.
     *
     * @return owner ID.
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Gets file ID.
     *
     * @return file ID.
     */
    public int getMediaId() {
        return mediaId;
    }

    /**
     * Gets file <i>access_key</i>.
     *
     * @return file <i>access_key</i>.
     */
    public String getAccessKey() {
        return accessKey;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(getType())
                .append(getOwnerId())
                .append("_")
                .append(getMediaId());

        if (getAccessKey() != null) {
            stringBuilder.append("_").append(getAccessKey());
        }

        return stringBuilder.toString();
    }
}
