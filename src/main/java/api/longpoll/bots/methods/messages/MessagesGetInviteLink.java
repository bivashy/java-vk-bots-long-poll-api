package api.longpoll.bots.methods.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesGetInviteLinkResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.getInviteLink</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getInviteLink">https://vk.com/dev/messages.getInviteLink</a>
 */
public class MessagesGetInviteLink extends GetMethod<GenericResult<MessagesGetInviteLinkResponse>> {
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
        return VkApi.getInstance().messagesGetInviteLink();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<MessagesGetInviteLinkResponse>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<MessagesGetInviteLinkResponse>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("reset", reset, true),
                keyVal("group_id", groupId)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesGetInviteLink setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Boolean getReset() {
        return reset;
    }

    public MessagesGetInviteLink setReset(Boolean reset) {
        this.reset = reset;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetInviteLink setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
