package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>utils.getShortLink</b> method.
 * <p>
 * Allows to receive a link shortened via vk.cc.
 *
 * @see <a href="https://vk.com/dev/utils.getShortLink">https://vk.com/dev/utils.getShortLink</a>
 */
public class GetShortLink extends VkMethod<GetShortLink.ResponseBody> {

    public GetShortLink(String accessToken) {
        super(property("utils.getShortLink"), accessToken);
    }

    public GetShortLink setUrl(String url) {
        return addParam("url", url);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetShortLink setPrivate(boolean isPrivate) {
        return addParam("private", isPrivate ? 1 : 0);
    }

    @Override
    public GetShortLink addParam(String key, Object value) {
        return (GetShortLink) super.addParam(key, value);
    }

    /**
     * Response to <b>utils.getShortLink</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
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
}
