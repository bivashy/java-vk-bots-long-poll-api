package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.editCallbackServer</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.editCallbackServer">https://vk.com/dev/groups.editCallbackServer</a>
 */
public class GroupsEditCallbackServer extends VkApiGetMethod<IntegerResult> {
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

    public GroupsEditCallbackServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsEditCallbackServer();
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

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public GroupsEditCallbackServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsEditCallbackServer setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }

    public GroupsEditCallbackServer setUrl(String url) {
        this.url = url;
        return this;
    }

    public GroupsEditCallbackServer setTitle(String title) {
        this.title = title;
        return this;
    }

    public GroupsEditCallbackServer setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }
}
