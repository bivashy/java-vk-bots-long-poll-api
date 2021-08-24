package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.setSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.setSettings">https://vk.com/dev/groups.setSettings</a>
 */
public class GroupsSetSettings extends VkApiGetMethod<IntegerResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Enable messages.
     */
    private Boolean messages;

    /**
     * Enable bots capabilities.
     */
    private Boolean botsCapabilities;

    /**
     * Allow adding bots to chat.
     */
    private Boolean botsAddToChat;

    public GroupsSetSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("groups.setSettings");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("messages", messages, true),
                keyVal("bots_capabilities", botsCapabilities, true),
                keyVal("bots_add_to_chat", botsAddToChat, true)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public GroupsSetSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsSetSettings setMessages(Boolean messages) {
        this.messages = messages;
        return this;
    }

    public GroupsSetSettings setBotsCapabilities(Boolean botsCapabilities) {
        this.botsCapabilities = botsCapabilities;
        return this;
    }

    public GroupsSetSettings setBotsAddToChat(Boolean botsAddToChat) {
        this.botsAddToChat = botsAddToChat;
        return this;
    }
}
