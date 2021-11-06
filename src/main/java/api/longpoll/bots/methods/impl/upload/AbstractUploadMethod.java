package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.methods.FileUploadingVkMethod;

public abstract class AbstractUploadMethod<Response> extends FileUploadingVkMethod<Response> {
    private String uploadUrl;

    @Override
    public String getUrl() {
        return uploadUrl;
    }

    public AbstractUploadMethod<Response> setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }
}
