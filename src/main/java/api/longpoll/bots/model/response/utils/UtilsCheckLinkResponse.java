package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>utils.checkLink</b> request.
 */
public class UtilsCheckLinkResponse {
    /**
     * Status.
     */
    @SerializedName("status")
    private String status;

    /**
     * Input link.
     */
    @SerializedName("link")
    private String link;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "UtilsCheckLinkResponse{" +
                "status='" + status + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
