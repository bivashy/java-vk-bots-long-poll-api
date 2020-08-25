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
