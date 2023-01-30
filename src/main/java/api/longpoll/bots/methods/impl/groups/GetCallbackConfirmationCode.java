package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.getCallbackConfirmationCode</b> method.
 * <p>
 * Returns Callback API confirmation code for the community.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackConfirmationCode">https://vk.com/dev/groups.getCallbackConfirmationCode</a>
 */
public class GetCallbackConfirmationCode extends VkMethod<GetCallbackConfirmationCode.ResponseBody> {
    public GetCallbackConfirmationCode(String accessToken) {
        super(, accessToken);
    }

    @Override
    public String getUri() {
        return property("groups.getCallbackConfirmationCode");
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
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
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
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
                return "Response{" +
                        "code='" + code + '\'' +
                        '}';
            }
        }
    }
}
