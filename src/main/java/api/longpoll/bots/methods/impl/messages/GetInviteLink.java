package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import api.longpoll.bots.utils.VkMethods;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>messages.getInviteLink</b> method.
 * <p>
 * Receives a link to invite a user to the chat.
 *
 * @see <a href="https://vk.com/dev/messages.getInviteLink">https://vk.com/dev/messages.getInviteLink</a>
 */
public class GetInviteLink extends VkMethod<GetInviteLink.ResponseBody> {

    public GetInviteLink(String accessToken) {
        super(VkMethods.get("messages.getInviteLink"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetInviteLink setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public GetInviteLink setReset(boolean reset) {
        return addParam("reset", reset ? 1 : 0);
    }

    public GetInviteLink setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetInviteLink addParam(String key, Object value) {
        return (GetInviteLink) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getInviteLink</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
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
                return "Response{" +
                        "link='" + link + '\'' +
                        '}';
            }
        }
    }
}
