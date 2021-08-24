package api.longpoll.bots.methods.docs;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>docs.getMessagesUploadServer</b> method.
 *
 * Returns the server address for document upload.
 *
 * @see <a href="https://vk.com/dev/docs.getMessagesUploadServer">https://vk.com/dev/docs.getMessagesUploadServer</a>
 */
public class DocsGetMessagesUploadServer extends VkApiGetMethod<DocsGetUploadServerResult> {
    /**
     * Document type.
     */
    private String type;

    /**
     * Destination ID.
     */
    private Integer peerId;

    public DocsGetMessagesUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("docs.getMessagesUploadServer");
    }


    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("type", type),
                keyVal("peer_id", peerId)
        );
    }

    @Override
    protected Class<? extends DocsGetUploadServerResult> getResultType() {
        return DocsGetUploadServerResult.class;
    }

    public DocsGetMessagesUploadServer setType(String type) {
        this.type = type;
        return this;
    }

    public DocsGetMessagesUploadServer setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }
}
