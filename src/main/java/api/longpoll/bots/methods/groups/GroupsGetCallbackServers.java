package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackServersResponseItem;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getCallbackServers</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackServers">https://vk.com/dev/groups.getCallbackServers</a>
 */
public class GroupsGetCallbackServers extends GetMethod<GenericResult<VkList<GroupsGetCallbackServersResponseItem>>> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Servers IDs to return.
     */
    private List<Integer> serverIds;

    public GroupsGetCallbackServers(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetCallbackServers();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<VkList<GroupsGetCallbackServersResponseItem>>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, VkList.class, GroupsGetCallbackServersResponseItem.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("server_ids", serverIds)
        );
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetCallbackServers setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public List<Integer> getServerIds() {
        return serverIds;
    }

    public GroupsGetCallbackServers setServerIds(List<Integer> serverIds) {
        this.serverIds = serverIds;
        return this;
    }
}
