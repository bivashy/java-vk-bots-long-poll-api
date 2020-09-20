package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.objects.additional.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>photos.saveOwnerCoverPhoto</b> request.
 */
public class PhotosSaveOwnerCoverPhotoResponse {
    /**
     * List of photo copies.
     */
    @SerializedName("images")
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
