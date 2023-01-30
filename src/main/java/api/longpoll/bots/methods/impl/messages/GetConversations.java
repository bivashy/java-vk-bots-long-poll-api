package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getConversations</b> method.
 * <p>
 * Returns a list of conversations.
 *
 * @see <a href="https://vk.com/dev/messages.getConversations">https://vk.com/dev/messages.getConversations</a>
 */
public class GetConversations extends VkMethod<GetConversations.ResponseBody> {
    public GetConversations(String accessToken) {
        super(, accessToken);
    }

    @Override
    public String getUri() {
        return property("messages.getConversations");
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetConversations setOffset(int offset) {
        return addParam("offset", offset);
    }

    public GetConversations setCount(int count) {
        return addParam("count", count);
    }

    public GetConversations setFilter(String filter) {
        return addParam("filter", filter);
    }

    public GetConversations setExtended(boolean extended) {
        return addParam("extended", extended ? 1 : 0);
    }

    public GetConversations setStartMessageId(int startMessageId) {
        return addParam("start_message_id", startMessageId);
    }

    public GetConversations setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetConversations setFields(List<String> fields) {
        return addParam("fields", csv(fields));
    }

    public GetConversations setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetConversations addParam(String key, Object value) {
        return (GetConversations) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getConversations</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ExtendedVkList<ResponseBody.Item>> {
        /**
         * Response item.
         */
        public static class Item {
            /**
             * Conversation object.
             */
            @SerializedName("conversation")
            private Conversation conversation;

            /**
             * Last message.
             */
            @SerializedName("last_message")
            private Message lastMessage;

            public Conversation getConversation() {
                return conversation;
            }

            public void setConversation(Conversation conversation) {
                this.conversation = conversation;
            }

            public Message getLastMessage() {
                return lastMessage;
            }

            public void setLastMessage(Message lastMessage) {
                this.lastMessage = lastMessage;
            }

            @Override
            public String toString() {
                return "Item{" +
                        "conversation=" + conversation +
                        ", lastMessage=" + lastMessage +
                        '}';
            }
        }
    }
}
