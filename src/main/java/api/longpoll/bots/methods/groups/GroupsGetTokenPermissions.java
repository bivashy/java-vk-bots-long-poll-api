package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.groups.GroupsGetTokenPermissionsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getTokenPermissions</b> method.
 *
 * Returns permissions scope for the community's access_token.
 *
 * @see <a href="https://vk.com/dev/groups.getTokenPermissions">https://vk.com/dev/groups.getTokenPermissions</a>
 */
public class GroupsGetTokenPermissions extends VkApiGetMethod<GroupsGetTokenPermissionsResult> {
    public GroupsGetTokenPermissions(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("groups.getTokenPermissions");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of();
    }

    @Override
    protected Class<? extends GroupsGetTokenPermissionsResult> getResultType() {
        return GroupsGetTokenPermissionsResult.class;
    }
}
