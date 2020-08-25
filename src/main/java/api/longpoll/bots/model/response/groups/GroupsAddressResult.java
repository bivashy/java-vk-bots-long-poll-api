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

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAdditionalAddress() {
			return additionalAddress;
		}

		public void setAdditionalAddress(String additionalAddress) {
			this.additionalAddress = additionalAddress;
		}

		public Integer getCountryId() {
			return countryId;
		}

		public void setCountryId(Integer countryId) {
			this.countryId = countryId;
		}

		public Integer getCityId() {
			return cityId;
		}

		public void setCityId(Integer cityId) {
			this.cityId = cityId;
		}

		public Integer getMetroStationId() {
			return metroStationId;
		}

		public void setMetroStationId(Integer metroStationId) {
			this.metroStationId = metroStationId;
		}

		public Float getLatitude() {
			return latitude;
		}

		public void setLatitude(Float latitude) {
			this.latitude = latitude;
		}

		public Float getLongitude() {
			return longitude;
		}

		public void setLongitude(Float longitude) {
			this.longitude = longitude;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getWorkInfoStatus() {
			return workInfoStatus;
		}

		public void setWorkInfoStatus(String workInfoStatus) {
			this.workInfoStatus = workInfoStatus;
		}

		public JsonObject getTimetable() {
			return timetable;
		}

		public void setTimetable(JsonObject timetable) {
			this.timetable = timetable;
		}

		public Boolean getMainAddress() {
			return mainAddress;
		}

		public void setMainAddress(Boolean mainAddress) {
			this.mainAddress = mainAddress;
		}
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
