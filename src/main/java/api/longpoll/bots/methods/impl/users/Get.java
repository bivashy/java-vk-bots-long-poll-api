package api.longpoll.bots.methods.impl.users;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.NameCase;
import api.longpoll.bots.model.objects.basic.User;
import api.longpoll.bots.model.response.GenericResponseBody;
import api.longpoll.bots.utils.ParamUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>users.get</b> method.
 * <p>
 * Returns detailed information on users.
 *
 * @see <a href="https://vk.com/dev/users.get">https://vk.com/dev/users.get</a>
 */
public class Get extends VkMethod<Get.ResponseBody> {
    public Get(String accessToken) {
        super(property("users.get"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public Get setUserIds(String... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public Get setUserIds(List<String> userIds) {
        return addParam("user_ids", ParamUtils.csv(userIds));
    }

    public Get setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public Get setFields(List<String> fields) {
        return addParam("fields", ParamUtils.csv(fields));
    }

    public Get setNameCase(NameCase nameCase) {
        return addParam("name_case", nameCase.getValue());
    }

    @Override
    public Get addParam(String key, Object value) {
        return (Get) super.addParam(key, value);
    }

    /**
     * Response to <b>users.get</b>
     */
    public static class ResponseBody extends GenericResponseBody<List<User>> {
    }
}
