package api.longpoll.bots.http.params;

import api.longpoll.bots.model.objects.media.Doc;

/**
 * Document attachment represented by {@link Doc}.
 */
public class DocAttachable extends BaseAttachable {
    public DocAttachable(Doc doc) {
        super("doc", doc.getOwnerId(), doc.getId(), doc.getAccessKey());
    }
}
