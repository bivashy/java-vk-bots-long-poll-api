package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getConversationsById</b> method.
 * <p>
 * Returns conversations by their IDs.
 *
 * @see <a href="https://vk.com/dev/messages.getConversationsById">https://vk.com/dev/messages.getConversationsById</a>
 */
public class GetConversationsById extends VkMethod<GetConversationsById.Response> {
    private final Converter<Boolean, Integer> boolIntConverter = VkBotsConfig.getInstance().getBoolIntConverter();
    private final Converter<List<?>, String> listConverter = VkBotsConfig.getInstance().getListConverter();

    public GetConversationsById(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkBotsConfig.getInstance().getBotMethods().getProperty("messages.getConversationsById");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetConversationsById setPeerIds(Integer... peerIds) {
        return setPeerIds(Arrays.asList(peerIds));
    }

    public GetConversationsById setPeerIds(List<Integer> peerIds) {
        return addParam("peer_ids", listConverter.convert(peerIds));
    }

    public GetConversationsById setExtended(boolean extended) {
        return addParam("extended", boolIntConverter.convert(extended));
    }

    public GetConversationsById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetConversationsById setFields(List<String> fields) {
        return addParam("fields", listConverter.convert(fields));
    }

    public GetConversationsById setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetConversationsById addParam(String key, Object value) {
        return (GetConversationsById) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getConversationsById</b> request.
     */
    public static class Response extends GenericResponse<ExtendedVkList<Response.ResponseObject.Item>> {
        /**
         * Response object.
         */
        public static class ResponseObject extends ExtendedVkList<ResponseObject.Item> {
            /**
             * Number of unread conversations.
             */
            @SerializedName("unread_count")
            private Integer unreadCount;

            /**
             * Describes VkList item.
             */
            public static class Item {
                /**
                 * Conversation object.
                 */
                @SerializedName("conversation")
                private Conversation conversation;

                /**
                 * Last message in conversation.
                 */
                @SerializedName("last_message")
                private Message message;

                public Conversation getConversation() {
                    return conversation;
                }

                public void setConversation(Conversation conversation) {
                    this.conversation = conversation;
                }

                public Message getMessage() {
                    return message;
                }

                public void setMessage(Message message) {
                    this.message = message;
                }

                @Override
                public String toString() {
                    return "Item{" +
                            "conversation=" + conversation +
                            ", message=" + message +
                            '}';
                }
            }

            public Integer getUnreadCount() {
                return unreadCount;
            }

            public void setUnreadCount(Integer unreadCount) {
                this.unreadCount = unreadCount;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "unreadCount=" + unreadCount +
                        "} " + super.toString();
            }
        }
    }
}
