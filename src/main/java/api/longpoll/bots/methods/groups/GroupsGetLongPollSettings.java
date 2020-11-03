package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollSettingsResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getLongPollSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getLongPollSettings">https://vk.com/dev/groups.getLongPollSettings</a>
 */
public class GroupsGetLongPollSettings extends GetMethod<GenericResult<GroupsGetLongPollSettingsResponse>> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetLongPollSettings(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetLongPollSettings();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<GroupsGetLongPollSettingsResponse>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<GroupsGetLongPollSettingsResponse>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetLongPollSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
