package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.methods.impl.VkMethod;

public abstract class UploadMethod<Response> extends VkMethod<Response> {
    private String url;

    @Override
    public String getUrl() {
        return url;
    }

    public UploadMethod<Response> setUrl(String uploadUrl) {
        this.url = uploadUrl;
        return this;
    }
}
