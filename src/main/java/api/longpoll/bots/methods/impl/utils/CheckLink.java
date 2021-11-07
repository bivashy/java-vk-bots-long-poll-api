package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>utils.checkLink</b> method.
 * <p>
 * Checks whether a link is blocked in VK.
 *
 * @see <a href="https://vk.com/dev/utils.checkLink">https://vk.com/dev/utils.checkLink</a>
 */
public class CheckLink extends VkMethod<CheckLink.Response> {
    public CheckLink(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkBotsConfig.getInstance().getBotMethods().getProperty("utils.checkLink");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public CheckLink setUrl(String url) {
        return addParam("url", url);
    }

    @Override
    public CheckLink addParam(String key, Object value) {
        return (CheckLink) super.addParam(key, value);
    }

    /**
     * Response to <b>utils.checkLink</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
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
                return "ResponseObject{" +
                        "status='" + status + '\'' +
                        ", link='" + link + '\'' +
                        '}';
            }
        }
    }
}
