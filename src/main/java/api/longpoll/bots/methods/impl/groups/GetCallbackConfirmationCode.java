package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.getCallbackConfirmationCode</b> method.
 * <p>
 * Returns Callback API confirmation code for the community.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackConfirmationCode">https://vk.com/dev/groups.getCallbackConfirmationCode</a>
 */
public class GetCallbackConfirmationCode extends AuthorizedVkApiMethod<GetCallbackConfirmationCode.Response> {
    public GetCallbackConfirmationCode(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getCallbackConfirmationCode");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetCallbackConfirmationCode setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetCallbackConfirmationCode addParam(String key, Object value) {
        return (GetCallbackConfirmationCode) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getCallbackConfirmationCode</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Confirmation code.
             */
            @SerializedName("code")
            private String code;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "code='" + code + '\'' +
                        '}';
            }
        }
    }
}
