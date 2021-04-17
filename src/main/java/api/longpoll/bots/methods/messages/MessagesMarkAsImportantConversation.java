package api.longpoll.bots.methods.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.markAsImportantConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsImportantConversation">https://vk.com/dev/messages.markAsImportantConversation</a>
 */
public class MessagesMarkAsImportantConversation extends GetMethod<GenericResult<Integer>> {
    /**
     * Peer Id.
     */
    private Integer peerId;

    /**
     * Answered.
     */
    private Boolean answered;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesMarkAsImportantConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesMarkAsImportantConversation();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("answered", answered, true),
                keyVal("group_id", groupId)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesMarkAsImportantConversation setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Boolean getAnswered() {
        return answered;
    }

    public MessagesMarkAsImportantConversation setAnswered(Boolean answered) {
        this.answered = answered;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesMarkAsImportantConversation setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
