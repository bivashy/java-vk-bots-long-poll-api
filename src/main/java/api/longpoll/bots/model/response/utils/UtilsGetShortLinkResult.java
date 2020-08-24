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

        public Response setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
            return this;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public Response setAccessKey(String accessKey) {
            this.accessKey = accessKey;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Response setKey(String key) {
            this.key = key;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Response setUrl(String url) {
            this.url = url;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public UtilsGetShortLinkResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
