package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

public class GroupsGetCallbackConfirmationCodeResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("code")
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
