package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.methods.impl.VkMethod;

/**
 * Generic method that uploads files to VK server.
 *
 * @param <Response> response type.
 */
public abstract class UploadMethod<Response> extends VkMethod<Response> {
    /**
     * URL to upload file.
     */
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
