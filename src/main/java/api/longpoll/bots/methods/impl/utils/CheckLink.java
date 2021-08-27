package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>utils.checkLink</b> method.
 * <p>
 * Checks whether a link is blocked in VK.
 *
 * @see <a href="https://vk.com/dev/utils.checkLink">https://vk.com/dev/utils.checkLink</a>
 */
public class CheckLink extends AuthorizedVkApiMethod<CheckLink.UtilsCheckLinkResult> {
    public CheckLink(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("utils.checkLink");
    }

    @Override
    protected Class<UtilsCheckLinkResult> getResponseType() {
        return UtilsCheckLinkResult.class;
    }

    public CheckLink setUrl(String url) {
        addParam("url", url);
        return this;
    }

    /**
     * Response to <b>utils.checkLink</b> request.
     */
    public static class UtilsCheckLinkResult extends GenericResponse<UtilsCheckLinkResult.ResponseObject> {
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
