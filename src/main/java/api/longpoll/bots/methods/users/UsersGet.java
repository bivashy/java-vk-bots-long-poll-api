package api.longpoll.bots.methods.users;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.users.UsersGetResult;
import org.jsoup.Connection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>users.get</b> method.
 *
 * Returns detailed information on users.
 *
 * @see <a href="https://vk.com/dev/users.get">https://vk.com/dev/users.get</a>
 */
public class UsersGet extends VkApiGetMethod<UsersGetResult> {
    /**
     * User IDs or screen names (screen_name).
     */
    private List<String> userIds;

    /**
     * Profile fields to return.
     */
    private List<String> fields;

    /**
     * Case for declension of user name and surname.
     */
    private String nameCase;

    public UsersGet(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().usersGet();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("user_ids", userIds),
                keyVal("fields", fields),
                keyVal("name_case", nameCase)
        );
    }

    @Override
    protected Class<? extends UsersGetResult> getResultType() {
        return UsersGetResult.class;
    }

    public UsersGet setUserIds(String... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public UsersGet setUserIds(List<String> userIds) {
        this.userIds = userIds;
        return this;
    }

    public UsersGet setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public UsersGet setNameCase(String nameCase) {
        this.nameCase = nameCase;
        return this;
    }
}
