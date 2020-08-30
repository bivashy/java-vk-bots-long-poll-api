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
* Implements <b>groups.deleteAddress</b> method.
* @see <a href="https://vk.com/dev/groups.deleteAddress">https://vk.com/dev/groups.deleteAddress</a>
*/
public class GroupsDeleteAddress extends GetMethod<GenericResult<Integer>> {
	/**
	 * Community ID.
	 */
	private Integer groupId;

	/**
	 * Address ID.
	 */
	private Integer addressId;

	public GroupsDeleteAddress(LongPollBot bot) {
		super(bot);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	protected String getApi() {
		return VkApi.getInstance().groupsDeleteAddress();
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
				keyVal("address_id", addressId)
		);
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
