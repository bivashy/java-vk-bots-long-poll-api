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

        public Response setType(String type) {
            this.type = type;
            return this;
        }

        public Integer getObjectId() {
            return objectId;
        }

        public Response setObjectId(Integer objectId) {
            this.objectId = objectId;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public UtilsResolveScreenNameResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
