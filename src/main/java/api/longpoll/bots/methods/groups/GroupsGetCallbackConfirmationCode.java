package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackConfirmationCodeResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getCallbackConfirmationCode</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackConfirmationCode">https://vk.com/dev/groups.getCallbackConfirmationCode</a>
 */
public class GroupsGetCallbackConfirmationCode extends GetMethod<GenericResult<GroupsGetCallbackConfirmationCodeResponse>> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetCallbackConfirmationCode(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetCallbackConfirmationCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<GroupsGetCallbackConfirmationCodeResponse>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<GroupsGetCallbackConfirmationCodeResponse>>(){}.getType());
    }

    /**
     * {@inheritDoc}
     */
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
