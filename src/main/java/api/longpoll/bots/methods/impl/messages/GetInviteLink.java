package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>messages.getInviteLink</b> method.
 * <p>
 * Receives a link to invite a user to the chat.
 *
 * @see <a href="https://vk.com/dev/messages.getInviteLink">https://vk.com/dev/messages.getInviteLink</a>
 */
public class GetInviteLink extends AuthorizedVkApiMethod<GetInviteLink.Response> {
    public GetInviteLink(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.getInviteLink");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetInviteLink setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public GetInviteLink setReset(boolean reset) {
        addParam("reset", new BoolInt(reset));
        return this;
    }

    public GetInviteLink setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    /**
     * Response to <b>messages.getInviteLink</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Link for inviting.
             */
            @SerializedName("link")
            private String link;

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "link='" + link + '\'' +
                        '}';
            }
        }
    }
}
