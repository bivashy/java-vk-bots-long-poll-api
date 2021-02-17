package api.longpoll.bots.methods.other;

import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.PostMethod;
import api.longpoll.bots.model.response.other.UploadStoryResult;
import org.jsoup.Connection;

import java.io.File;
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
    protected String getType() {
        return "video_file";
    }

    @Override
    protected String getApi() {
        return uploadUrl;
    }

    @Override
    protected JsonToPojoConverter<UploadStoryResult> getConverter() {
        return CachedConverterFactory.getConverter(UploadStoryResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of();
    }

    public File getStory() {
        return getFile();
    }

    public UploadStory setStory(File story) {
        setFile(story);
        return this;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public UploadStory setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }
}
