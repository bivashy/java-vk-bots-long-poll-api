package api.longpoll.bots.methods.photos;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>photos.saveMessagesPhoto</b> method.
 *
 * Saves a photo after being successfully uploaded. URL obtained with photos.getMessagesUploadServer method.
 *
 * @see <a href="https://vk.com/dev/photos.saveMessagesPhoto">https://vk.com/dev/photos.saveMessagesPhoto</a>
 */
public class PhotosSaveMessagesPhoto extends VkApiGetMethod<PhotosSaveMessagesPhotoResult> {
    /**
     * Parameter returned when photo upload to the server.
     */
    private String photo;

    /**
     * Server ID.
     */
    private Integer server;

    /**
     * Hash.
     */
    private String hash;

    public PhotosSaveMessagesPhoto(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().photosSaveMessagesPhoto();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("photo", photo),
                keyVal("server", server),
                keyVal("hash", hash)
        );
    }

    @Override
    protected Class<? extends PhotosSaveMessagesPhotoResult> getResultType() {
        return PhotosSaveMessagesPhotoResult.class;
    }

    public PhotosSaveMessagesPhoto setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public PhotosSaveMessagesPhoto setServer(Integer server) {
        this.server = server;
        return this;
    }

    public PhotosSaveMessagesPhoto setHash(String hash) {
        this.hash = hash;
        return this;
    }
}
