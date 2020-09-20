package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getLongPollServer</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getLongPollServer">https://vk.com/dev/groups.getLongPollServer</a>
 */
public class GroupsGetLongPollServer extends GetMethod<GenericResult<GroupsGetLongPollServerResponse>> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetLongPollServer(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected JsonToPojoConverter<GenericResult<GroupsGetLongPollServerResponse>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<GroupsGetLongPollServerResponse>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetLongPollServer();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetLongPollServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
