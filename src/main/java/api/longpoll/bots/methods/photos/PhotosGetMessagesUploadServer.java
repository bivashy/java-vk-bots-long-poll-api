package api.longpoll.bots.methods.photos;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.photos.PhotosGetMessagesUploadServerResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>photos.getMessagesUploadServer</b> method.
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
        return VkApi.getInstance().photosGetMessagesUploadServer();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(param("peer_id", peerId));
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
