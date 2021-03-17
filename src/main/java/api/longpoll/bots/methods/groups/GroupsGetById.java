package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.basic.Community;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getById</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getById">https://vk.com/dev/groups.getById</a>
 */
public class GroupsGetById extends GetMethod<List<Community>> {
    /**
     * IDs or screen names of communities.
     */
    private List<String> groupIds;

    /**
     * ID or screen name of the community.
     */
    private String groupId;

    /**
     * Group fields to return.
     */
    private List<String> fields;

    public GroupsGetById(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetById();
    }

    @Override
    protected JsonToPojoConverter<List<Community>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<List<Community>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_ids", groupIds),
                keyVal("group_id", groupId),
                keyVal("fields", fields)
        );
    }

    public List<String> getGroupIds() {
        return groupIds;
    }

    public GroupsGetById setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
        return this;
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupsGetById setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public GroupsGetById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
