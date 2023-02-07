package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.response.GenericResponseBody;
import api.longpoll.bots.utils.ParamUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>groups.getById</b> method.
 * <p>
 * Returns information about communities by their IDs.
 *
 * @see <a href="https://vk.com/dev/groups.getById">https://vk.com/dev/groups.getById</a>
 */
public class GetById extends VkMethod<GetById.ResponseBody> {
    public GetById(String accessToken) {
        super(property("groups.getById"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetById setGroupIds(String... groupIds) {
        return setGroupIds(Arrays.asList(groupIds));
    }

    public GetById setGroupIds(List<String> groupIds) {
        return addParam("group_ids", ParamUtils.csv(groupIds));
    }

    public GetById setGroupId(String groupId) {
        return addParam("group_id", groupId);
    }

    public GetById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetById setFields(List<String> fields) {
        return addParam("fields", ParamUtils.csv(fields));
    }

    @Override
    public GetById addParam(String key, Object value) {
        return (GetById) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getById</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<List<Community>> {
    }
}
