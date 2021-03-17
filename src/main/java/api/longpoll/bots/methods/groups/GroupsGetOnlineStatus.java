package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetOnlineStatusResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getOnlineStatus</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getOnlineStatus">https://vk.com/dev/groups.getOnlineStatus</a>
 */
public class GroupsGetOnlineStatus extends GetMethod<GenericResult<GroupsGetOnlineStatusResponse>> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetOnlineStatus(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetOnlineStatus();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<GroupsGetOnlineStatusResponse>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<GroupsGetOnlineStatusResponse>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetOnlineStatus setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
