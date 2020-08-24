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

        public Item setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Item setTitle(String title) {
            this.title = title;
            return this;
        }

        public Integer getCreatorId() {
            return creatorId;
        }

        public Item setCreatorId(Integer creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Item setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public Item setSecretKey(String secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public Item setStatus(String status) {
            this.status = status;
            return this;
        }
    }

    public VkList<Item> getResponse() {
        return response;
    }

    public GroupsGetCallbackServersResult setResponse(VkList<Item> response) {
        this.response = response;
        return this;
    }
}
