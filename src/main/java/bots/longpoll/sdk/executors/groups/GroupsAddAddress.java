package bots.longpoll.sdk.executors.groups;

import bots.longpoll.sdk.LongPollBot;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.groups.GroupsAddAddressResponseConverterImpl;
import bots.longpoll.sdk.executors.GetExecutor;
import bots.longpoll.sdk.executors.VkApi;
import bots.longpoll.sdk.model.groups.GroupsAddAddressResponse;
import com.google.gson.JsonObject;

public class GroupsAddAddress extends GetExecutor<GroupsAddAddressResponse> {
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

	public int getGroupId() {
		return (int) params.get(GROUP_ID);
	}

	public GroupsAddAddress setTitle(String title) {
		params.put(TITLE, title);
		return this;
	}

	public String getTitle() {
		return (String) params.get(TITLE);
	}

	public GroupsAddAddress setAddress(String address) {
		params.put(ADDRESS, address);
		return this;
	}

	public String getAddress() {
		return (String) params.get(ADDRESS);
	}

	public GroupsAddAddress setAdditionalAddress(String additionalAddress) {
		params.put(ADDITIONAL_ADDRESS, additionalAddress);
		return this;
	}

	public String getAdditionalAddress() {
		return (String) params.get(ADDITIONAL_ADDRESS);
	}

	public GroupsAddAddress setCountryId(int countryId) {
		params.put(COUNTRY_ID, countryId);
		return this;
	}

	public int getCountryId() {
		return (int) params.get(COUNTRY_ID);
	}

	public GroupsAddAddress setCityId(int cityId) {
		params.put(CITY_ID, cityId);
		return this;
	}

	public int getCityId() {
		return (int) params.get(CITY_ID);
	}

	public GroupsAddAddress setMetroId(int metroId) {
		params.put(METRO_ID, metroId);
		return this;
	}

	public int getMetroId() {
		return (int) params.get(METRO_ID);
	}

	public GroupsAddAddress setLatitude(float latitude) {
		params.put(LATITUDE, latitude);
		return this;
	}

	public float getLatitude() {
		return (float) params.get(LATITUDE);
	}

	public GroupsAddAddress setLongitude(float longitude) {
		params.put(LONGITUDE, longitude);
		return this;
	}

	public float getLongitude() {
		return (float) params.get(LONGITUDE);
	}

	public GroupsAddAddress setPhone(String phone) {
		params.put(PHONE, phone);
		return this;
	}

	public String getPhone() {
		return (String) params.get(PHONE);
	}

	public GroupsAddAddress setWorkInfoStatus(String workInfoStatus) {
		params.put(WORK_INFO_STATUS, workInfoStatus);
		return this;
	}

	public String getWorkInfoStatus() {
		return (String) params.get(WORK_INFO_STATUS);
	}

	public GroupsAddAddress setMainAddress(boolean mainAddress) {
		params.put(IS_MAIN_ADDRESS, mainAddress ? 1 : 0);
		return this;
	}

	public boolean isMainAddress() {
		return (int) params.get(IS_MAIN_ADDRESS) == 1;
	}

	public GroupsAddAddress setTimetable(JsonObject timetable) {
		params.put(TIMETABLE, timetable);
		return this;
	}

	public JsonObject getTimetable() {
		return (JsonObject) params.get(TIMETABLE);
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.ADD_ADDRESS;
	}

	@Override
	protected JsonToPojoConverter<GroupsAddAddressResponse> getConverter() {
		return new GroupsAddAddressResponseConverterImpl();
	}
}
