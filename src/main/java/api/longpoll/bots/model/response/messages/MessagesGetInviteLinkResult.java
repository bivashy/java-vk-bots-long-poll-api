package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.getInviteLink</b> request.
 */
public class MessagesGetInviteLinkResult extends GenericResult<MessagesGetInviteLinkResult.Response> {
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
