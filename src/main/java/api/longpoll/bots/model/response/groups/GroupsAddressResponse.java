package api.longpoll.bots.model.response.groups;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.addAddress</b> request.
 */
public class GroupsAddressResponse {
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
        return "GroupsAddressResponse{" +
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
