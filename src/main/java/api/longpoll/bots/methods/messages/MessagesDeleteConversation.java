package api.longpoll.bots.methods.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesDeleteConversationResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.deleteConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.deleteConversation">https://vk.com/dev/messages.deleteConversation</a>
 */
public class MessagesDeleteConversation extends GetMethod<GenericResult<MessagesDeleteConversationResponse>> {
    /**
     * User ID.
     */
    private String userId;

    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * Community ID.
     */
    private Integer groupId;

    public MessagesDeleteConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesDeleteConversation();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<MessagesDeleteConversationResponse>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<MessagesDeleteConversationResponse>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("user_id", userId),
                keyVal("peer_id", peerId),
                keyVal("group_id", groupId)
        );
    }

    public String getUserId() {
        return userId;
    }

    public MessagesDeleteConversation setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesDeleteConversation setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesDeleteConversation setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
