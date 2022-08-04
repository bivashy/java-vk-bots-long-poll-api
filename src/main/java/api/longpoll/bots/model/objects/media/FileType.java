package api.longpoll.bots.model.objects.media;

/**
 * Type of file to be uploaded to VK server.
 */
public enum FileType {
    FILE("file"),
    PHOTO("photo"),
    VIDEO_FILE("video_file");

    private final String value;

    FileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
