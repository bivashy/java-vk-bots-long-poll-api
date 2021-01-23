package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.deleteCallbackServer</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.deleteCallbackServer">https://vk.com/dev/groups.deleteCallbackServer</a>
 */
public class GroupsDeleteCallbackServer extends GetMethod<GenericResult<Integer>> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Server ID.
     */
    private Integer serverId;

    public GroupsDeleteCallbackServer(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsDeleteCallbackServer();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, Integer.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("server_id", serverId)
        );
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsDeleteCallbackServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getServerId() {
        return serverId;
    }

    public GroupsDeleteCallbackServer setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }
}
