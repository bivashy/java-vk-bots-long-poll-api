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

/**
* Implements <b>groups.editCallbackServer</b> method.
* @see <a href="https://vk.com/dev/groups.editCallbackServer">https://vk.com/dev/groups.editCallbackServer</a>
*/
public class GroupsEditCallbackServer extends GetMethod<GenericResult<Integer>> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Server ID.
     */
    private Integer serverId;

    /**
     * Server's new URL.
     */
    private String url;

    /**
     * Server's new title.
     */
    private String title;

    /**
     * Server's new secret key.
     */
    private String secretKey;

    public GroupsEditCallbackServer(LongPollBot bot) {
        super(bot);
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected String getApi() {
        return VkApi.getInstance().groupsEditCallbackServer();
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    /**
	* {@inheritDoc}
	*/
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
