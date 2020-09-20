package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getLongPollServer</b> request.
 */
public class GroupsGetLongPollServerResponse {
    /**
     * Key.
     */
    @SerializedName("key")
    private String key;

    /**
     * Server URL.
     */
    @SerializedName("server")
    private String server;

    /**
     * Timestamp.
     */
    @SerializedName("ts")
    private Integer ts;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }
}
