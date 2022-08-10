package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>utils.checkLink</b> method.
 * <p>
 * Checks whether a link is blocked in VK.
 *
 * @see <a href="https://vk.com/dev/utils.checkLink">https://vk.com/dev/utils.checkLink</a>
 */
public class CheckLink extends VkMethod<CheckLink.ResponseBody> {
    public CheckLink(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("utils.checkLink");
    }

    public CheckLink setUrl(String url) {
        return addParam("url", url);
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    @Override
    public CheckLink addParam(String key, Object value) {
        return (CheckLink) super.addParam(key, value);
    }

    /**
     * Response to <b>utils.checkLink</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
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
                return "Response{" +
                        "status='" + status + '\'' +
                        ", link='" + link + '\'' +
                        '}';
            }
        }
    }
}
