package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>utils.getShortLink</b> request.
 */
public class UtilsGetShortLinkResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response.
     */
    public static class Response {
        /**
         * Shortened URL.
         */
        @SerializedName("short_url")
        private String shortUrl;

        /**
         * Access key for private stats.
         */
        @SerializedName("access_key")
        private String accessKey;

        /**
         * Link key (characters after "vk.cc").
         */
        @SerializedName("key")
        private String key;

        /**
         * Full URL.
         */
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
