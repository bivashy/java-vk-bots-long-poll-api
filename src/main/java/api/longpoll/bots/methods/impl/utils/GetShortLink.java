package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>utils.getShortLink</b> method.
 * <p>
 * Allows to receive a link shortened via vk.cc.
 *
 * @see <a href="https://vk.com/dev/utils.getShortLink">https://vk.com/dev/utils.getShortLink</a>
 */
public class GetShortLink extends AuthorizedVkApiMethod<GetShortLink.Response> {
    public GetShortLink(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("utils.getShortLink");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetShortLink setUrl(String url) {
        return addParam("url", url);
    }

    public GetShortLink setPrivate(boolean isPrivate) {
        return addParam("private", new BoolInt(isPrivate));
    }

    @Override
    public GetShortLink addParam(String key, Object value) {
        return (GetShortLink) super.addParam(key, value);
    }

    /**
     * Response to <b>utils.getShortLink</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
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
                return "ResponseObject{" +
                        "shortUrl='" + shortUrl + '\'' +
                        ", accessKey='" + accessKey + '\'' +
                        ", key='" + key + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }
    }
}
