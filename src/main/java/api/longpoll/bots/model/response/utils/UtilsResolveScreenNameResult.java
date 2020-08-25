package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

public class UtilsResolveScreenNameResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("type")
        private String type;
        @SerializedName("object_id")
        private Integer objectId;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getObjectId() {
            return objectId;
        }

        public void setObjectId(Integer objectId) {
            this.objectId = objectId;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
