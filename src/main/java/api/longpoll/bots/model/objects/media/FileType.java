package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.methods.VkApiPostMethod;

/**
 * Type of file to be uploaded to VK server in {@link VkApiPostMethod}.
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
