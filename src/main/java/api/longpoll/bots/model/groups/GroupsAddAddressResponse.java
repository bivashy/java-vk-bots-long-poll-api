package api.longpoll.bots.model.groups;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class GroupsAddAddressResponse {
	@SerializedName("group_id")
	private Integer groupId;
	@SerializedName("title")
	private String title;
	@SerializedName("address")
	private String address;
	@SerializedName("additional_address")
	private String additionalAddress;
	@SerializedName("country_id")
	private Integer countryId;
	@SerializedName("city_id")
	private Integer cityId;
	@SerializedName("metro_id")
	private Integer metroId;
	@SerializedName("latitude")
	private Float latitude;
	@SerializedName("longitude")
	private Float longtitude;
	@SerializedName("phone")
	private String phone;
	@SerializedName("work_info_status")
	private String workInfoStatus;
	@SerializedName("timetable")
	private JsonObject timetable;
	@SerializedName("is_main_address")
	private Boolean mainAddress;

	public Integer getGroupId() {
		return groupId;
	}

	public GroupsAddAddressResponse setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public GroupsAddAddressResponse setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public GroupsAddAddressResponse setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getAdditionalAddress() {
		return additionalAddress;
	}

	public GroupsAddAddressResponse setAdditionalAddress(String additionalAddress) {
		this.additionalAddress = additionalAddress;
		return this;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public GroupsAddAddressResponse setCountryId(Integer countryId) {
		this.countryId = countryId;
		return this;
	}

	public Integer getCityId() {
		return cityId;
	}

	public GroupsAddAddressResponse setCityId(Integer cityId) {
		this.cityId = cityId;
		return this;
	}

	public Integer getMetroId() {
		return metroId;
	}

	public GroupsAddAddressResponse setMetroId(Integer metroId) {
		this.metroId = metroId;
		return this;
	}

	public Float getLatitude() {
		return latitude;
	}

	public GroupsAddAddressResponse setLatitude(Float latitude) {
		this.latitude = latitude;
		return this;
	}

	public Float getLongtitude() {
		return longtitude;
	}

	public GroupsAddAddressResponse setLongtitude(Float longtitude) {
		this.longtitude = longtitude;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public GroupsAddAddressResponse setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getWorkInfoStatus() {
		return workInfoStatus;
	}

	public GroupsAddAddressResponse setWorkInfoStatus(String workInfoStatus) {
		this.workInfoStatus = workInfoStatus;
		return this;
	}

	public JsonObject getTimetable() {
		return timetable;
	}

	public GroupsAddAddressResponse setTimetable(JsonObject timetable) {
		this.timetable = timetable;
		return this;
	}

	public Boolean getMainAddress() {
		return mainAddress;
	}

	public GroupsAddAddressResponse setMainAddress(Boolean mainAddress) {
		this.mainAddress = mainAddress;
		return this;
	}
}
