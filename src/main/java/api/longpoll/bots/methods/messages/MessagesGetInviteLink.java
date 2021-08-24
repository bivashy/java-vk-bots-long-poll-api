package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.messages.MessagesGetInviteLinkResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.getInviteLink</b> method.
 *
 * Receives a link to invite a user to the chat.
 *
 * @see <a href="https://vk.com/dev/messages.getInviteLink">https://vk.com/dev/messages.getInviteLink</a>
 */
public class MessagesGetInviteLink extends VkApiGetMethod<MessagesGetInviteLinkResult> {
    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * <b>true</b> — to generate new link.
     */
    private Boolean reset;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesGetInviteLink(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("messages.getInviteLink");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("reset", reset, true),
                keyVal("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesGetInviteLinkResult> getResultType() {
        return MessagesGetInviteLinkResult.class;
    }

    public MessagesGetInviteLink setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesGetInviteLink setReset(Boolean reset) {
        this.reset = reset;
        return this;
    }

    public MessagesGetInviteLink setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
