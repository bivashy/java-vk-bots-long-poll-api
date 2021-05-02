package api.longpoll.bots.methods.other;

import api.longpoll.bots.methods.VkApiPostMethod;
import api.longpoll.bots.model.objects.media.FileType;
import api.longpoll.bots.model.response.other.UploadStoryResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements uploading story in VK API.
 */
public class UploadStory extends VkApiPostMethod<UploadStoryResult> {
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
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
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
