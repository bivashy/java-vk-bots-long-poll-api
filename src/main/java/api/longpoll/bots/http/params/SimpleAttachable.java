package api.longpoll.bots.http.params;

import api.longpoll.bots.exceptions.VkApiException;

/**
 * Any attachment represented by {@link String}.
 */
public class SimpleAttachable implements AttachableParam {
    private String attachment;

    public SimpleAttachable(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String attach() throws VkApiException {
        return attachment;
    }
}
