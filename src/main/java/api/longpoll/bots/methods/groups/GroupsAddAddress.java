package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsAddressResult;
import com.google.gson.JsonObject;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsAddAddress extends GetMethod<GroupsAddressResult> {
	private Integer groupId;
	private String title;
	private String address;
	private String additionalAddress;
	private Integer countryId;
	private Integer cityId;
	private Integer metroId;
	private Float latitude;
	private Float longitude;
	private String phone;
	private String workInfoStatus;
	private JsonObject timeTable;
	private Boolean mainAddress;

	public GroupsAddAddress(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.getInstance().groupsAddAddress();
	}

	@Override
	protected JsonToPojoConverter<GroupsAddressResult> getConverter() {
		return GenericConverterFactory.get(GroupsAddressResult.class);
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of(
				keyVal("group_id", groupId),
				keyVal("title", title),
				keyVal("address", address),
				keyVal("additional_address", additionalAddress),
				keyVal("country_id", countryId),
				keyVal("city_id", cityId),
				keyVal("metro_id", metroId),
				keyVal("latitude", latitude),
				keyVal("longitude", longitude),
				keyVal("phone", phone),
				keyVal("work_info_status", workInfoStatus),
				keyVal("timetable", timeTable),
				keyVal("is_main_address", mainAddress, true)
		);
	}

	public Integer getGroupId() {
		return groupId;
	}

	public GroupsAddAddress setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public GroupsAddAddress setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public GroupsAddAddress setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getAdditionalAddress() {
		return additionalAddress;
	}

	public GroupsAddAddress setAdditionalAddress(String additionalAddress) {
		this.additionalAddress = additionalAddress;
		return this;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public GroupsAddAddress setCountryId(Integer countryId) {
		this.countryId = countryId;
		return this;
	}

	public Integer getCityId() {
		return cityId;
	}

	public GroupsAddAddress setCityId(Integer cityId) {
		this.cityId = cityId;
		return this;
	}

	public Integer getMetroId() {
		return metroId;
	}

	public GroupsAddAddress setMetroId(Integer metroId) {
		this.metroId = metroId;
		return this;
	}

	public Float getLatitude() {
		return latitude;
	}

	public GroupsAddAddress setLatitude(Float latitude) {
		this.latitude = latitude;
		return this;
	}

	public Float getLongitude() {
		return longitude;
	}

	public GroupsAddAddress setLongitude(Float longitude) {
		this.longitude = longitude;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public GroupsAddAddress setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getWorkInfoStatus() {
		return workInfoStatus;
	}

	public GroupsAddAddress setWorkInfoStatus(String workInfoStatus) {
		this.workInfoStatus = workInfoStatus;
		return this;
	}

	public JsonObject getTimeTable() {
		return timeTable;
	}

	public GroupsAddAddress setTimeTable(JsonObject timeTable) {
		this.timeTable = timeTable;
		return this;
	}

	public Boolean getMainAddress() {
		return mainAddress;
	}

	public GroupsAddAddress setMainAddress(Boolean mainAddress) {
		this.mainAddress = mainAddress;
		return this;
	}
}
