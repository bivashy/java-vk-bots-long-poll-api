package api.longpoll.bots.methods.other;

import api.longpoll.bots.methods.PostMethod;
import api.longpoll.bots.model.objects.media.FileType;
import api.longpoll.bots.model.response.other.UploadStoryResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements uploading story in VK API.
 */
public class UploadStory extends PostMethod<UploadStoryResult> {
    /**
     * Upload URL.
     */
    private String uploadUrl;

    @Override
    protected FileType getType() {
        return FileType.VIDEO_FILE;
    }

    @Override
    protected String getApi() {
        return uploadUrl;
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of();
    }

    @Override
    protected Class<? extends UploadStoryResult> getResultType() {
        return UploadStoryResult.class;
    }

    public UploadStory setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }
}
