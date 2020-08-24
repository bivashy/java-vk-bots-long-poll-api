package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsEditCallbackServer extends GetMethod<GenericResult<Integer>> {
    private Integer groupId;
    private Integer serverId;
    private String url;
    private String title;
    private String secretKey;

    public GroupsEditCallbackServer(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsEditCallbackServer();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("server_id", serverId),
                keyVal("url", url),
                keyVal("title", title),
                keyVal("secret_key", secretKey)
        );
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsEditCallbackServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getServerId() {
        return serverId;
    }

    public GroupsEditCallbackServer setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GroupsEditCallbackServer setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GroupsEditCallbackServer setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public GroupsEditCallbackServer setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }
}
