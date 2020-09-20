package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetTokenPermissionsResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getTokenPermissions</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getTokenPermissions">https://vk.com/dev/groups.getTokenPermissions</a>
 */
public class GroupsGetTokenPermissions extends GetMethod<GenericResult<GroupsGetTokenPermissionsResponse>> {
    public GroupsGetTokenPermissions(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetTokenPermissions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<GroupsGetTokenPermissionsResponse>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<GroupsGetTokenPermissionsResponse>>(){}.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of();
    }
}
