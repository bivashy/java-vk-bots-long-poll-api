package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>utils.resolveScreenName</b> request.
 */
public class UtilsResolveScreenNameResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response.
     */
    public static class Response {
        /**
         * Object type (user, group, application).
         */
        @SerializedName("type")
        private String type;

        /**
         * Object ID.
         */
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
