package api.longpoll.bots.http.params;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.media.Doc;

/**
 * Document attachment represented by {@link Doc}.
 */
public class DocAttachable extends AbstractAttachable {
    private Doc doc;

    public DocAttachable(Doc doc) {
        this.doc = doc;
    }

    @Override
    public String attach() throws VkApiException {
        return toAttachmentString("doc", doc.getOwnerId(), doc.getId(), doc.getAccessKey());
    }
}
