package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>messages.deleteConversation</b> method.
 * <p>
 * Deletes private messages in a conversation.
 *
 * @see <a href="https://vk.com/dev/messages.deleteConversation">https://vk.com/dev/messages.deleteConversation</a>
 */
public class DeleteConversation extends AuthorizedVkApiMethod<DeleteConversation.Response> {
    public DeleteConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.deleteConversation");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public DeleteConversation setUserId(String userId) {
        return addParam("user_id", userId);
    }

    public DeleteConversation setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public DeleteConversation setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public DeleteConversation addParam(String key, Object value) {
        return (DeleteConversation) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.deleteConversation</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Last deleted message ID.
             */
            @SerializedName("last_deleted_id")
            private Integer lastDeletedId;

            public Integer getLastDeletedId() {
                return lastDeletedId;
            }

            public void setLastDeletedId(Integer lastDeletedId) {
                this.lastDeletedId = lastDeletedId;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "lastDeletedId=" + lastDeletedId +
                        '}';
            }
        }
    }
}
