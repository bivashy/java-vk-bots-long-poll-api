package api.longpoll.bots.methods.photos;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.photos.PhotosSaveOwnerCoverPhotoResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>photos.saveOwnerCoverPhoto</b> method.
 *
 * @see <a href="https://vk.com/dev/photos.saveOwnerCoverPhoto">https://vk.com/dev/photos.saveOwnerCoverPhoto</a>
 */
public class PhotosSaveOwnerCoverPhoto extends VkApiGetMethod<PhotosSaveOwnerCoverPhotoResult> {
    /**
     * Parameter returned when photo is uploaded to server.
     */
    private String hash;

    /**
     * Parameter returned when photo is uploaded to server.
     */
    private String photo;

    public PhotosSaveOwnerCoverPhoto(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().photosSaveOwnerCoverPhoto();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("hash", hash),
                param("photo", photo)
        );
    }

    @Override
    protected Class<? extends PhotosSaveOwnerCoverPhotoResult> getResultType() {
        return PhotosSaveOwnerCoverPhotoResult.class;
    }

    public PhotosSaveOwnerCoverPhoto setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public PhotosSaveOwnerCoverPhoto setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}
