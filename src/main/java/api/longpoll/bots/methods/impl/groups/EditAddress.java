package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;

/**
 * Implements <b>groups.editAddress</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.editAddress">https://vk.com/dev/groups.editAddress</a>
 */
public class EditAddress extends AuthorizedVkApiMethod<EditAddress.Response> {

    public EditAddress(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.editAddress");
    }

    @Override
    protected Class<Response> getResponseType() {
        return null;
    }

    public EditAddress setAddressId(int addressId) {
        addParam("address_id", addressId);
        return this;
    }

    public EditAddress setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public EditAddress setTitle(String title) {
        addParam("title", title);
        return this;
    }

    public EditAddress setAddress(String address) {
        addParam("address", address);
        return this;
    }

    public EditAddress setAdditionalAddress(String additionalAddress) {
        addParam("additional_address", additionalAddress);
        return this;
    }

    public EditAddress setCountryId(int countryId) {
        addParam("country_id", countryId);
        return this;
    }

    public EditAddress setCityId(int cityId) {
        addParam("city_id", cityId);
        return this;
    }

    public EditAddress setMetroId(int metroId) {
        addParam("metro_id", metroId);
        return this;
    }

    public EditAddress setLatitude(float latitude) {
        addParam("latitude", latitude);
        return this;
    }

    public EditAddress setLongitude(float longitude) {
        addParam("longitude", longitude);
        return this;
    }

    public EditAddress setPhone(String phone) {
        addParam("phone", phone);
        return this;
    }

    public EditAddress setWorkInfoStatus(String workInfoStatus) {
        addParam("work_info_status", workInfoStatus);
        return this;
    }

    public EditAddress setTimeTable(String timeTable) {
        addParam("timetable", timeTable);
        return this;
    }

    public EditAddress setMainAddress(boolean mainAddress) {
        addParam("is_main_address", new BoolInt(mainAddress));
        return this;
    }

    /**
     * Response to <b>groups.editAddress</b> request.
     */
    public static class Response extends AddAddress.Response {
    }
}
