package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>utils.resolveScreenName</b> method.
 * <p>
 * Detects a type of object (e.g., user, community, application) and its ID by screen name.
 *
 * @see <a href="https://vk.com/dev/utils.resolveScreenName">https://vk.com/dev/utils.resolveScreenName</a>
 */
public class ResolveScreenName extends VkMethod<ResolveScreenName.ResponseBody> {
    public ResolveScreenName(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("utils.resolveScreenName");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    public ResolveScreenName setScreenName(String screenName) {
        return addParam("screen_name", screenName);
    }

    @Override
    public ResolveScreenName addParam(String key, Object value) {
        return (ResolveScreenName) super.addParam(key, value);
    }

    /**
     * Response to <b>utils.resolveScreenName</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
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

            @Override
            public String toString() {
                return "Response{" +
                        "type='" + type + '\'' +
                        ", objectId=" + objectId +
                        '}';
            }
        }
    }
}
