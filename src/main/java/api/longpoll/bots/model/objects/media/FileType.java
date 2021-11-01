package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.methods.FileUploadingVkApiMethod;

/**
 * Type of file to be uploaded to VK server in {@link FileUploadingVkApiMethod}.
 */
public enum FileType {
    FILE("file"),
    PHOTO("photo"),
    VIDEO_FILE("video_file");

    /**
     * File type name to be passed as request argument.
     */
    private final String key;

    FileType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
