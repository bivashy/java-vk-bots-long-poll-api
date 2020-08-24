package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackConfirmationCodeResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsGetCallbackConfirmationCode extends GetMethod<GroupsGetCallbackConfirmationCodeResult> {
    private Integer groupId;

    public GroupsGetCallbackConfirmationCode(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetCallbackConfirmationCode();
    }

    @Override
    protected JsonToPojoConverter<GroupsGetCallbackConfirmationCodeResult> getConverter() {
        return GenericConverterFactory.get(GroupsGetCallbackConfirmationCodeResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetCallbackConfirmationCode setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
