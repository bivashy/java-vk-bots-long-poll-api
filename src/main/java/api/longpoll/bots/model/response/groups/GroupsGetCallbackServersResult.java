package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.objects.additional.VkList;
import com.google.gson.annotations.SerializedName;

public class GroupsGetCallbackServersResult {
    @SerializedName("response")
    private VkList<Item> response;

    public static class Item {
        @SerializedName("id")
        private Integer id;
        @SerializedName("title")
        private String title;
        @SerializedName("creator_id")
        private Integer creatorId;
        @SerializedName("url")
        private String url;
        @SerializedName("secret_key")
        private String secretKey;
        @SerializedName("status")
        private String status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(Integer creatorId) {
            this.creatorId = creatorId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public VkList<Item> getResponse() {
        return response;
    }

    public void setResponse(VkList<Item> response) {
        this.response = response;
    }
}
