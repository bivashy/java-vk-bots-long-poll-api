package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.deleteAddress</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.deleteAddress">https://vk.com/dev/groups.deleteAddress</a>
 */
public class DeleteAddress extends AuthorizedVkApiMethod<IntegerResponse> {
    public DeleteAddress(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.deleteAddress");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public DeleteAddress setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public DeleteAddress setAddressId(int addressId) {
        return addParam("address_id", addressId);
    }

    @Override
    public DeleteAddress addParam(String key, Object value) {
        return (DeleteAddress) super.addParam(key, value);
    }
}
