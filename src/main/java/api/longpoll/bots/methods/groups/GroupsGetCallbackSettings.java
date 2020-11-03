package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackSettingsResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getCallbackSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackSettings">https://vk.com/dev/groups.getCallbackSettings</a>
 */
public class GroupsGetCallbackSettings extends GetMethod<GenericResult<GroupsGetCallbackSettingsResponse>> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Server ID.
     */
    private Integer serverId;

    public GroupsGetCallbackSettings(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetCallbackSettings();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<GroupsGetCallbackSettingsResponse>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<GroupsGetCallbackSettingsResponse>>(){}.getType());
    }

    /**
     * {@inheritDoc}
     */
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

    public GroupsGetCallbackSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getServerId() {
        return serverId;
    }

    public GroupsGetCallbackSettings setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }
}
