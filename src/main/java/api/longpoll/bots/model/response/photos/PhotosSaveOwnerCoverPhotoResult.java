package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.objects.additional.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosSaveOwnerCoverPhotoResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("images")
        private List<Image> images;

        public List<Image> getImages() {
            return images;
        }

        public Response setImages(List<Image> images) {
            this.images = images;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public PhotosSaveOwnerCoverPhotoResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
