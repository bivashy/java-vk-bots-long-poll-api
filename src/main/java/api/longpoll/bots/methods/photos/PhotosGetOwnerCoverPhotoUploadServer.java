package api.longpoll.bots.methods.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.photos.PhotosGetOwnerCoverPhotoUploadServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class PhotosGetOwnerCoverPhotoUploadServer extends GetMethod<PhotosGetOwnerCoverPhotoUploadServerResult> {
    private Integer groupId;
    private Integer cropX;
    private Integer cropY;
    private Integer cropX2;
    private Integer cropY2;

    public PhotosGetOwnerCoverPhotoUploadServer(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Photos.GET_OWNER_COVER_PHOTO_UPLOAD_SERVER;
    }

    @Override
    protected JsonToPojoConverter<PhotosGetOwnerCoverPhotoUploadServerResult> getConverter() {
        return GenericConverterFactory.get(PhotosGetOwnerCoverPhotoUploadServerResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("crop_x", cropX),
                keyVal("crop_y", cropY),
                keyVal("crop_x2", cropX2),
                keyVal("crop_y2", cropY2)
        );
    }

    public Integer getGroupId() {
        return groupId;
    }

    public PhotosGetOwnerCoverPhotoUploadServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getCropX() {
        return cropX;
    }

    public PhotosGetOwnerCoverPhotoUploadServer setCropX(Integer cropX) {
        this.cropX = cropX;
        return this;
    }

    public Integer getCropY() {
        return cropY;
    }

    public PhotosGetOwnerCoverPhotoUploadServer setCropY(Integer cropY) {
        this.cropY = cropY;
        return this;
    }

    public Integer getCropX2() {
        return cropX2;
    }

    public PhotosGetOwnerCoverPhotoUploadServer setCropX2(Integer cropX2) {
        this.cropX2 = cropX2;
        return this;
    }

    public Integer getCropY2() {
        return cropY2;
    }

    public PhotosGetOwnerCoverPhotoUploadServer setCropY2(Integer cropY2) {
        this.cropY2 = cropY2;
        return this;
    }
}
