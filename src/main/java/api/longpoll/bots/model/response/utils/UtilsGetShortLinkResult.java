package api.longpoll.bots.model.response.utils;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>utils.getShortLink</b> request.
 */
public class UtilsGetShortLinkResult extends GenericResult<UtilsGetShortLinkResult.Response> {
    /**
     * Response object.
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

        @Override
        public String toString() {
            return "Response{" +
                    "shortUrl='" + shortUrl + '\'' +
                    ", accessKey='" + accessKey + '\'' +
                    ", key='" + key + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
