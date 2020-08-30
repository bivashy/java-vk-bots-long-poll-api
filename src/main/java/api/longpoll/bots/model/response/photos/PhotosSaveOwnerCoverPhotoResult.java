package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.objects.additional.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>photos.saveOwnerCoverPhoto</b> request.
 */
public class PhotosSaveOwnerCoverPhotoResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response object.
     */
    public static class Response {
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

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
