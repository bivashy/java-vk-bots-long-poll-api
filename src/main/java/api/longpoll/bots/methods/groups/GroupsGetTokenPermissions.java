package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetTokenPermissionsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsGetTokenPermissions extends GetMethod<GroupsGetTokenPermissionsResult> {
    public GroupsGetTokenPermissions(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetTokenPermissions();
    }

    @Override
    protected JsonToPojoConverter<GroupsGetTokenPermissionsResult> getConverter() {
        return GenericConverterFactory.get(GroupsGetTokenPermissionsResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of();
    }
}
