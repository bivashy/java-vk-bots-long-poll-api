package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getCallbackConfirmationCode</b> request.
 */
public class GroupsGetCallbackConfirmationCodeResponse {
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
}
