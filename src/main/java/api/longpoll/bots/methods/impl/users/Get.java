package api.longpoll.bots.methods.impl.users;

import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.converter.impl.ListConverter;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.basic.User;
import api.longpoll.bots.model.response.GenericResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>users.get</b> method.
 * <p>
 * Returns detailed information on users.
 *
 * @see <a href="https://vk.com/dev/users.get">https://vk.com/dev/users.get</a>
 */
public class Get extends VkMethod<Get.Response> {
    private final Converter<List<?>, String> listConverter = new ListConverter();

    public Get(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("users.get");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public Get setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public Get setUserIds(List<Integer> userIds) {
        return addParam("user_ids", toCommaSeparatedValues(userIds));
    }

    public Get setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public Get setFields(List<String> fields) {
        return addParam("fields", toCommaSeparatedValues(fields));
    }

    public Get setNameCase(String nameCase) {
        return addParam("name_case", nameCase);
    }

    @Override
    public Get addParam(String key, Object value) {
        return (Get) super.addParam(key, value);
    }

    /**
     * Response to <b>users.get</b>
     */
    public static class Response extends GenericResponse<List<User>> {
    }
}
