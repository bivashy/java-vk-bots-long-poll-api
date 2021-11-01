package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.addAddress</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.addAddress">https://vk.com/dev/groups.addAddress</a>
 */
public class AddAddress extends AuthorizedVkApiMethod<AddAddress.Response> {
    public AddAddress(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.addAddress");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public AddAddress setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public AddAddress setTitle(String title) {
        return addParam("title", title);
    }

    public AddAddress setAddress(String address) {
        return addParam("address", address);
    }

    public AddAddress setAdditionalAddress(String additionalAddress) {
        return addParam("additional_address", additionalAddress);
    }

    public AddAddress setCountryId(int countryId) {
        return addParam("country_id", countryId);
    }

    public AddAddress setCityId(int cityId) {
        return addParam("city_id", cityId);
    }

    public AddAddress setMetroId(int metroId) {
        return addParam("metro_id", metroId);
    }

    public AddAddress setLatitude(float latitude) {
        return addParam("latitude", latitude);
    }

    public AddAddress setLongitude(float longitude) {
        return addParam("longitude", longitude);
    }

    public AddAddress setPhone(String phone) {
        return addParam("phone", phone);
    }

    public AddAddress setWorkInfoStatus(String workInfoStatus) {
        return addParam("work_info_status", workInfoStatus);
    }

    public AddAddress setTimeTable(String timeTable) {
        return addParam("timetable", timeTable);
    }

    public AddAddress setMainAddress(boolean mainAddress) {
        return addParam("is_main_address", new BoolInt(mainAddress));
    }

    @Override
    public AddAddress addParam(String key, Object value) {
        return (AddAddress) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.addAddress</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Address ID.
             */
            @SerializedName("id")
            private Integer id;

            /**
             * Address title.
             */
            @SerializedName("title")
            private String title;

            /**
             * Address.
             */
            @SerializedName("address")
            private String address;

            /**
             * Additional address description.
             */
            @SerializedName("additional_address")
            private String additionalAddress;

            /**
             * Country ID.
             */
            @SerializedName("country_id")
            private Integer countryId;

            /**
             * City ID.
             */
            @SerializedName("city_id")
            private Integer cityId;

            /**
             * Metro station ID.
             */
            @SerializedName("metro_station_id")
            private Integer metroStationId;

            /**
             * Geographical latitude.
             */
            @SerializedName("latitude")
            private Float latitude;

            /**
             * geographical longitude.
             */
            @SerializedName("longitude")
            private Float longitude;

            /**
             * Phone number.
             */
            @SerializedName("phone")
            private String phone;

            /**
             * Schedule type.
             */
            @SerializedName("work_info_status")
            private String workInfoStatus;

            /**
             * Schedule.
             */
            @SerializedName("timetable")
            private JsonObject timetable;

            /**
             * Whether address is main.
             */
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

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", address='" + address + '\'' +
                        ", additionalAddress='" + additionalAddress + '\'' +
                        ", countryId=" + countryId +
                        ", cityId=" + cityId +
                        ", metroStationId=" + metroStationId +
                        ", latitude=" + latitude +
                        ", longitude=" + longitude +
                        ", phone='" + phone + '\'' +
                        ", workInfoStatus='" + workInfoStatus + '\'' +
                        ", timetable=" + timetable +
                        ", mainAddress=" + mainAddress +
                        '}';
            }
        }
    }
}
