package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsAddressResult;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>groups.addAddress</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.addAddress">https://vk.com/dev/groups.addAddress</a>
 */
public class GroupsAddAddress extends VkApiGetMethod<GroupsAddressResult> {
    /**
     * Group ID.
     */
    private Integer groupId;

    /**
     * Address name.
     */
    private String title;

    /**
     * Address string.
     */
    private String address;

    /**
     * Additional address.
     */
    private String additionalAddress;

    /**
     * County ID.
     */
    private Integer countryId;

    /**
     * City ID.
     */
    private Integer cityId;

    /**
     * Metro station ID.
     */
    private Integer metroId;

    /**
     * Geographical latitude.
     */
    private Float latitude;

    /**
     * Geographical longitude.
     */
    private Float longitude;

    /**
     * Phone number.
     */
    private String phone;

    /**
     * Working status.
     */
    private String workInfoStatus;

    /**
     * Work timetable.
     */
    private JsonObject timeTable;

    /**
     * <b>true</b> if address is main.
     */
    private Boolean mainAddress;

    public GroupsAddAddress(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsAddAddress();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("group_id", groupId),
                param("title", title),
                param("address", address),
                param("additional_address", additionalAddress),
                param("country_id", countryId),
                param("city_id", cityId),
                param("metro_id", metroId),
                param("latitude", latitude),
                param("longitude", longitude),
                param("phone", phone),
                param("work_info_status", workInfoStatus),
                param("timetable", timeTable),
                param("is_main_address", mainAddress, true)
        );
    }

    @Override
    protected Class<? extends GroupsAddressResult> getResultType() {
        return GroupsAddressResult.class;
    }

    public GroupsAddAddress setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsAddAddress setTitle(String title) {
        this.title = title;
        return this;
    }

    public GroupsAddAddress setAddress(String address) {
        this.address = address;
        return this;
    }

    public GroupsAddAddress setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
        return this;
    }

    public GroupsAddAddress setCountryId(Integer countryId) {
        this.countryId = countryId;
        return this;
    }

    public GroupsAddAddress setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public GroupsAddAddress setMetroId(Integer metroId) {
        this.metroId = metroId;
        return this;
    }

    public GroupsAddAddress setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public GroupsAddAddress setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public GroupsAddAddress setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public GroupsAddAddress setWorkInfoStatus(String workInfoStatus) {
        this.workInfoStatus = workInfoStatus;
        return this;
    }

    public GroupsAddAddress setTimeTable(JsonObject timeTable) {
        this.timeTable = timeTable;
        return this;
    }

    public GroupsAddAddress setMainAddress(Boolean mainAddress) {
        this.mainAddress = mainAddress;
        return this;
    }
}
