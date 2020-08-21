package api.longpoll.bots.methods.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.photos.PhotosSaveOwnerCoverPhotoResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class PhotosSaveOwnerCoverPhoto extends GetMethod<PhotosSaveOwnerCoverPhotoResult> {
    private String hash;
    private String photo;

    public PhotosSaveOwnerCoverPhoto(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Photos.SAVE_OWNER_COVER_PHOTO;
    }

    @Override
    protected JsonToPojoConverter<PhotosSaveOwnerCoverPhotoResult> getConverter() {
        return GenericConverterFactory.get(PhotosSaveOwnerCoverPhotoResult.class);
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
