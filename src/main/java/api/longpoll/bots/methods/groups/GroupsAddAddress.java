package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsAddAddressResult;
import com.google.gson.JsonObject;

public class GroupsAddAddress extends GetMethod<GroupsAddAddressResult> {
	private static final String GROUP_ID = "group_id";
	private static final String TITLE = "title";
	private static final String ADDRESS = "address";
	private static final String ADDITIONAL_ADDRESS = "additional_address";
	private static final String COUNTRY_ID = "country_id";
	private static final String CITY_ID = "city_id";
	private static final String METRO_ID = "metro_id";
	private static final String LATITUDE = "latitude";
	private static final String LONGITUDE = "longitude";
	private static final String PHONE = "phone";
	private static final String WORK_INFO_STATUS = "work_info_status";
	private static final String IS_MAIN_ADDRESS = "is_main_address";
	private static final String TIMETABLE = "timetable";

	public GroupsAddAddress(LongPollBot bot) {
		super(bot);
	}

	public GroupsAddAddress setGroupId(int groupId) {
		params.put(GROUP_ID, groupId);
		return this;
	}

	public GroupsAddAddress setTitle(String title) {
		params.put(TITLE, title);
		return this;
	}

	public GroupsAddAddress setAddress(String address) {
		params.put(ADDRESS, address);
		return this;
	}

	public GroupsAddAddress setAdditionalAddress(String additionalAddress) {
		params.put(ADDITIONAL_ADDRESS, additionalAddress);
		return this;
	}

	public GroupsAddAddress setCountryId(int countryId) {
		params.put(COUNTRY_ID, countryId);
		return this;
	}

	public GroupsAddAddress setCityId(int cityId) {
		params.put(CITY_ID, cityId);
		return this;
	}

	public GroupsAddAddress setMetroId(int metroId) {
		params.put(METRO_ID, metroId);
		return this;
	}

	public GroupsAddAddress setLatitude(float latitude) {
		params.put(LATITUDE, latitude);
		return this;
	}

	public GroupsAddAddress setLongitude(float longitude) {
		params.put(LONGITUDE, longitude);
		return this;
	}

	public GroupsAddAddress setPhone(String phone) {
		params.put(PHONE, phone);
		return this;
	}

	public GroupsAddAddress setWorkInfoStatus(String workInfoStatus) {
		params.put(WORK_INFO_STATUS, workInfoStatus);
		return this;
	}

	public GroupsAddAddress setMainAddress(boolean mainAddress) {
		params.put(IS_MAIN_ADDRESS, mainAddress ? 1 : 0);
		return this;
	}

	public GroupsAddAddress setTimetable(JsonObject timetable) {
		params.put(TIMETABLE, timetable);
		return this;
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.ADD_ADDRESS;
	}

	@Override
	protected JsonToPojoConverter<GroupsAddAddressResult> getConverter() {
		return GenericConverterFactory.get(GroupsAddAddressResult.class);
	}
}
