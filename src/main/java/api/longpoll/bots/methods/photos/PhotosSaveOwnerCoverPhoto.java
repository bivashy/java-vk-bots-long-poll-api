package api.longpoll.bots.methods.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.photos.PhotosSaveOwnerCoverPhotoResponse;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>photos.saveOwnerCoverPhoto</b> method.
 *
 * @see <a href="https://vk.com/dev/photos.saveOwnerCoverPhoto">https://vk.com/dev/photos.saveOwnerCoverPhoto</a>
 */
public class PhotosSaveOwnerCoverPhoto extends GetMethod<GenericResult<PhotosSaveOwnerCoverPhotoResponse>> {
    /**
     * Parameter returned when photo is uploaded to server.
     */
    private String hash;

    /**
     * Parameter returned when photo is uploaded to server.
     */
    private String photo;

    public PhotosSaveOwnerCoverPhoto(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().photosSaveOwnerCoverPhoto();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<PhotosSaveOwnerCoverPhotoResponse>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, PhotosSaveOwnerCoverPhotoResponse.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("hash", hash),
                keyVal("photo", photo)
        );
    }

    public String getHash() {
        return hash;
    }

    public PhotosSaveOwnerCoverPhoto setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public PhotosSaveOwnerCoverPhoto setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}
