package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.markAsImportantConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsImportantConversation">https://vk.com/dev/messages.markAsImportantConversation</a>
 */
public class MessagesMarkAsImportantConversation extends VkApiGetMethod<IntegerResult> {
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
        return VkApiProperties.get("messages.markAsImportantConversation");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("answered", answered, true),
                keyVal("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public MessagesMarkAsImportantConversation setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesMarkAsImportantConversation setAnswered(Boolean answered) {
        this.answered = answered;
        return this;
    }

    public MessagesMarkAsImportantConversation setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
