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
        return addParam("address_id", addressId);
    }

    public EditAddress setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public EditAddress setTitle(String title) {
        return addParam("title", title);
    }

    public EditAddress setAddress(String address) {
        return addParam("address", address);
    }

    public EditAddress setAdditionalAddress(String additionalAddress) {
        return addParam("additional_address", additionalAddress);
    }

    public EditAddress setCountryId(int countryId) {
        return addParam("country_id", countryId);
    }

    public EditAddress setCityId(int cityId) {
        return addParam("city_id", cityId);
    }

    public EditAddress setMetroId(int metroId) {
        return addParam("metro_id", metroId);
    }

    public EditAddress setLatitude(float latitude) {
        return addParam("latitude", latitude);
    }

    public EditAddress setLongitude(float longitude) {
        return addParam("longitude", longitude);
    }

    public EditAddress setPhone(String phone) {
        return addParam("phone", phone);
    }

    public EditAddress setWorkInfoStatus(String workInfoStatus) {
        return addParam("work_info_status", workInfoStatus);
    }

    public EditAddress setTimeTable(String timeTable) {
        return addParam("timetable", timeTable);
    }

    public EditAddress setMainAddress(boolean mainAddress) {
        return addParam("is_main_address", new BoolInt(mainAddress));
    }

    @Override
    public EditAddress addParam(String key, Object value) {
        return (EditAddress) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.editAddress</b> request.
     */
    public static class Response extends AddAddress.Response {
    }
}
