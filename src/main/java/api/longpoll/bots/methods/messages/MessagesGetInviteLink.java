package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetInviteLinkResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class MessagesGetInviteLink extends GetMethod<MessagesGetInviteLinkResult> {
    private Integer peerId;
    private Boolean reset;
    private Integer groupId;

    public MessagesGetInviteLink(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetInviteLink();
    }

    @Override
    protected JsonToPojoConverter<MessagesGetInviteLinkResult> getConverter() {
        return GenericConverterFactory.get(MessagesGetInviteLinkResult.class);
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
