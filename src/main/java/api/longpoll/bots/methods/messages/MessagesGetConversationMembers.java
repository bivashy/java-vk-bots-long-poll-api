package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetConversationMembersResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
* Implements <b>messages.getConversationMembers</b> method.
* @see <a href="https://vk.com/dev/messages.getConversationMembers">https://vk.com/dev/messages.getConversationMembers</a>
*/
public class MessagesGetConversationMembers extends GetMethod<MessagesGetConversationMembersResult> {
    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * List of additional fields for users and communities.
     */
    private List<String> fields;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesGetConversationMembers(LongPollBot bot) {
        super(bot);
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetConversationMembers();
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected JsonToPojoConverter<MessagesGetConversationMembersResult> getConverter() {
        return GenericConverterFactory.get(MessagesGetConversationMembersResult.class);
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesGetConversationMembers setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetConversationMembers setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetConversationMembers setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
