package api.longpoll.bots.model.response.groups;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class GroupsAddressResult {
	@SerializedName("response")
	private Response response;

	public static class Response {
		@SerializedName("id")
		private Integer id;
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
		@SerializedName("metro_station_id")
		private Integer metroStationId;
		@SerializedName("latitude")
		private Float latitude;
		@SerializedName("longitude")
		private Float longitude;
		@SerializedName("phone")
		private String phone;
		@SerializedName("work_info_status")
		private String workInfoStatus;
		@SerializedName("timetable")
		private JsonObject timetable;
		@SerializedName("is_main_address")
		private Boolean mainAddress;

		public Integer getId() {
			return id;
		}

		public Response setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getTitle() {
			return title;
		}

		public Response setTitle(String title) {
			this.title = title;
			return this;
		}

		public String getAddress() {
			return address;
		}

		public Response setAddress(String address) {
			this.address = address;
			return this;
		}

		public String getAdditionalAddress() {
			return additionalAddress;
		}

		public Response setAdditionalAddress(String additionalAddress) {
			this.additionalAddress = additionalAddress;
			return this;
		}

		public Integer getCountryId() {
			return countryId;
		}

		public Response setCountryId(Integer countryId) {
			this.countryId = countryId;
			return this;
		}

		public Integer getCityId() {
			return cityId;
		}

		public Response setCityId(Integer cityId) {
			this.cityId = cityId;
			return this;
		}

		public Integer getMetroStationId() {
			return metroStationId;
		}

		public Response setMetroStationId(Integer metroStationId) {
			this.metroStationId = metroStationId;
			return this;
		}

		public Float getLatitude() {
			return latitude;
		}

		public Response setLatitude(Float latitude) {
			this.latitude = latitude;
			return this;
		}

		public Float getLongitude() {
			return longitude;
		}

		public Response setLongitude(Float longitude) {
			this.longitude = longitude;
			return this;
		}

		public String getPhone() {
			return phone;
		}

		public Response setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public String getWorkInfoStatus() {
			return workInfoStatus;
		}

		public Response setWorkInfoStatus(String workInfoStatus) {
			this.workInfoStatus = workInfoStatus;
			return this;
		}

		public JsonObject getTimetable() {
			return timetable;
		}

		public Response setTimetable(JsonObject timetable) {
			this.timetable = timetable;
			return this;
		}

		public Boolean getMainAddress() {
			return mainAddress;
		}

		public Response setMainAddress(Boolean mainAddress) {
			this.mainAddress = mainAddress;
			return this;
		}
	}

	public Response getResponse() {
		return response;
	}

	public GroupsAddressResult setResponse(Response response) {
		this.response = response;
		return this;
	}
}
