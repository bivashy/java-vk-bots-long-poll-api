package api.longpoll.bots.methods.other;

import api.longpoll.bots.methods.PostMethod;
import api.longpoll.bots.model.objects.media.FileType;
import api.longpoll.bots.model.response.other.UploadDocResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements uploading document in VK API.
 */
public class UploadDoc extends PostMethod<UploadDocResult> {
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
    protected Class<? extends UploadDocResult> getResultType() {
        return UploadDocResult.class;
    }

    @Override
    protected FileType getType() {
        return FileType.FILE;
    }

    public UploadDoc setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }
}
