package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsAddressResult;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>groups.editAddress</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.editAddress">https://vk.com/dev/groups.editAddress</a>
 */
public class GroupsEditAddress extends VkApiGetMethod<GroupsAddressResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Address ID.
     */
    private Integer addressId;

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

    public GroupsEditAddress(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsEditAddress();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("group_id", groupId),
                param("address_id", addressId),
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

    public GroupsEditAddress setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsEditAddress setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public GroupsEditAddress setTitle(String title) {
        this.title = title;
        return this;
    }

    public GroupsEditAddress setAddress(String address) {
        this.address = address;
        return this;
    }

    public GroupsEditAddress setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
        return this;
    }

    public GroupsEditAddress setCountryId(Integer countryId) {
        this.countryId = countryId;
        return this;
    }

    public GroupsEditAddress setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public GroupsEditAddress setMetroId(Integer metroId) {
        this.metroId = metroId;
        return this;
    }

    public GroupsEditAddress setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public GroupsEditAddress setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public GroupsEditAddress setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public GroupsEditAddress setWorkInfoStatus(String workInfoStatus) {
        this.workInfoStatus = workInfoStatus;
        return this;
    }

    public GroupsEditAddress setTimeTable(JsonObject timeTable) {
        this.timeTable = timeTable;
        return this;
    }

    public GroupsEditAddress setMainAddress(Boolean mainAddress) {
        this.mainAddress = mainAddress;
        return this;
    }
}
