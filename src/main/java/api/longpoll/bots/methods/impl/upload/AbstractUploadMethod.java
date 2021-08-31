package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.methods.FileUploadingVkApiMethod;

public abstract class AbstractUploadMethod<Response> extends FileUploadingVkApiMethod<Response> {
    private String uploadUrl;

    @Override
    protected String getUrl() {
        return uploadUrl;
    }

    public AbstractUploadMethod<Response> setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }
}
