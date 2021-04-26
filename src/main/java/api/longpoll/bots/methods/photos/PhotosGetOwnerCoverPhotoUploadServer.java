package api.longpoll.bots.methods.photos;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.photos.PhotosGetOwnerCoverPhotoUploadServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>photos.getOwnerCoverPhotoUploadServer</b> method.
 *
 * @see <a href="https://vk.com/dev/photos.getOwnerCoverPhotoUploadServer">https://vk.com/dev/photos.getOwnerCoverPhotoUploadServer</a>
 */
public class PhotosGetOwnerCoverPhotoUploadServer extends GetMethod<PhotosGetOwnerCoverPhotoUploadServerResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * X coordinate of the left-upper corner.
     */
    private Integer cropX;

    /**
     * Y coordinate of the left-upper corner.
     */
    private Integer cropY;

    /**
     * X coordinate of the right-bottom corner.
     */
    private Integer cropX2;

    /**
     * Y coordinate of the right-bottom corner.
     */
    private Integer cropY2;

    public PhotosGetOwnerCoverPhotoUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().photosGetOwnerCoverPhotoUploadServer();
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

    @Override
    protected Class<? extends PhotosGetOwnerCoverPhotoUploadServerResult> getResultType() {
        return PhotosGetOwnerCoverPhotoUploadServerResult.class;
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
