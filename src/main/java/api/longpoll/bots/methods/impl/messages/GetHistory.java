package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.User;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getHistory</b> method.
 * <p>
 * Returns message history for the specified user or group chat.
 *
 * @see <a href="https://vk.com/dev/messages.getHistory">https://vk.com/dev/messages.getHistory</a>
 */
public class GetHistory extends AuthorizedVkApiMethod<GetHistory.Response> {
    public GetHistory(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.getHistory");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetHistory setOffset(int offset) {
        addParam("offset", offset);
        return this;
    }

    public GetHistory setCount(int count) {
        addParam("count", count);
        return this;
    }

    public GetHistory setUserId(int userId) {
        addParam("user_id", userId);
        return this;
    }

    public GetHistory setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public GetHistory setStartMessageId(int startMessageId) {
        addParam("start_message_id", startMessageId);
        return this;
    }

    public GetHistory setRev(boolean rev) {
        addParam("rev", new BoolInt(rev));
        return this;
    }

    public GetHistory setExtended(boolean extended) {
        addParam("extended", new BoolInt(extended));
        return this;
    }

    public GetHistory setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetHistory setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    public GetHistory setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    /**
     * Response to <b>messages.getHistory</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject extends VkList<Message> {
            /**
             * Number of unread messages.
             */
            @SerializedName("unread")
            private Integer unread;

            /**
             * List of conversations.
             */
            @SerializedName("conversations")
            private List<Conversation> conversations;

            /**
             * List of users.
             */
            @SerializedName("profiles")
            private List<User> profiles;

            public Integer getUnread() {
                return unread;
            }

            public void setUnread(Integer unread) {
                this.unread = unread;
            }

            public List<Conversation> getConversations() {
                return conversations;
            }

            public void setConversations(List<Conversation> conversations) {
                this.conversations = conversations;
            }

            public List<User> getProfiles() {
                return profiles;
            }

            public void setProfiles(List<User> profiles) {
                this.profiles = profiles;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "unread=" + unread +
                        ", conversations=" + conversations +
                        ", profiles=" + profiles +
                        "} " + super.toString();
            }
        }
    }
}
