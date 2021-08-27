package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>messages.isMessagesFromGroupAllowed</b> method.
 * <p>
 * Returns information whether sending messages from the community to current user is allowed.
 *
 * @see <a href="https://vk.com/dev/messages.isMessagesFromGroupAllowed">https://vk.com/dev/messages.isMessagesFromGroupAllowed</a>
 */
public class IsMessagesFromGroupAllowed extends AuthorizedVkApiMethod<IsMessagesFromGroupAllowed.Response> {
    public IsMessagesFromGroupAllowed(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.isMessagesFromGroupAllowed");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public IsMessagesFromGroupAllowed setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public IsMessagesFromGroupAllowed setUserId(int userId) {
        addParam("user_id", userId);
        return this;
    }

    /**
     * Response to <b>messages.isMessagesFromGroupAllowed</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            @SerializedName("is_allowed")
            @JsonAdapter(BoolIntDeserializer.class)
            private Boolean isAllowed;

            public Boolean getAllowed() {
                return isAllowed;
            }

            public void setAllowed(Boolean allowed) {
                isAllowed = allowed;
            }


            @Override
            public String toString() {
                return "ResponseObject{" +
                        "isAllowed=" + isAllowed +
                        '}';
            }
        }
    }
}
