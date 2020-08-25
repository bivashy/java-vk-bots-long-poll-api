package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

public class UtilsGetShortLinkResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("short_url")
        private String shortUrl;
        @SerializedName("access_key")
        private String accessKey;
        @SerializedName("key")
        private String key;
        @SerializedName("url")
        private String url;

        public String getShortUrl() {
            return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
