package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.deleteAddress</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.deleteAddress">https://vk.com/dev/groups.deleteAddress</a>
 */
public class GroupsDeleteAddress extends GetMethod<IntegerResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Address ID.
     */
    private Integer addressId;

    public GroupsDeleteAddress(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsDeleteAddress();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("address_id", addressId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsDeleteAddress setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public GroupsDeleteAddress setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }
}
