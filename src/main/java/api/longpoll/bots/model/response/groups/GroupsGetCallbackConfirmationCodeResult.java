package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getCallbackConfirmationCode</b> request.
 */
public class GroupsGetCallbackConfirmationCodeResult extends GenericResult<GroupsGetCallbackConfirmationCodeResult.Response> {
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
