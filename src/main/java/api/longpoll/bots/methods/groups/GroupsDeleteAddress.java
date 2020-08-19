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

public class GroupsDeleteAddress extends GetMethod<GenericResult<Integer>> {
	private Integer groupId;
	private Integer addressId;

	public GroupsDeleteAddress(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.DELETE_ADDRESS;
	}

	@Override
	protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
		return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
	}

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
