package api.longpoll.bots.model.objects.additional;

/**
 * An uploaded to VK server file.
 */
public abstract class UploadedFile {
    /**
     * Gets file type.
     *
     * @return file type.
     */
    public abstract String getType();

    /**
     * Gets owner ID.
     *
     * @return owner ID.
     */
    public abstract int getOwnerId();

    /**
     * Gets file ID.
     *
     * @return file ID.
     */
    public abstract int getMediaId();

    /**
     * Gets file <i>access_key</i>.
     *
     * @return file <i>access_key</i>.
     */
    public abstract String getAccessKey();

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
