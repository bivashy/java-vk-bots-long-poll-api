package api.longpoll.bots.methods.photos;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.photos.PhotosGetMessagesUploadServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>photos.getMessagesUploadServer</b> method.
 *
 * Returns the server address for photo upload in a private message for a user.
 *
 * @see <a href="https://vk.com/dev/photos.getMessagesUploadServer">https://vk.com/dev/photos.getMessagesUploadServer</a>
 */
public class PhotosGetMessagesUploadServer extends VkApiGetMethod<PhotosGetMessagesUploadServerResult> {
    /**
     * User ID.
     */
    private Integer peerId;

    public PhotosGetMessagesUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("photos.getMessagesUploadServer");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(keyVal("peer_id", peerId));
    }

    @Override
    protected Class<? extends PhotosGetMessagesUploadServerResult> getResultType() {
        return PhotosGetMessagesUploadServerResult.class;
    }

    public PhotosGetMessagesUploadServer setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }
}
