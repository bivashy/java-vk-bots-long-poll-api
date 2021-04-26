package api.longpoll.bots.model.objects.media;

/**
 * Type of file to be uploaded to VK server in {@link api.longpoll.bots.methods.PostMethod}.
 */
public enum FileType {
    FILE("file"),
    PHOTO("photo"),
    VIDEO_FILE("video_file");

    /**
     * File type name to be passed as request argument.
     */
    public String name;

    FileType(String name) {
        this.name = name;
    }
}
