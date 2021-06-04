package api.longpoll.bots.methods.upload;

import api.longpoll.bots.methods.VkApiPostMethod;
import api.longpoll.bots.model.objects.media.FileType;
import api.longpoll.bots.model.response.other.UploadPhotoResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements uploading photo in VK API.
 */
public class UploadPhoto extends VkApiPostMethod<UploadPhotoResult> {
    /**
     * Upload URL.
     */
    private String uploadUrl;

    @Override
    protected String getApi() {
        return uploadUrl;
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of();
    }

    @Override
    protected Class<? extends UploadPhotoResult> getResultType() {
        return UploadPhotoResult.class;
    }

    @Override
    protected FileType getType() {
        return FileType.PHOTO;
    }

    public UploadPhoto setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }
}
