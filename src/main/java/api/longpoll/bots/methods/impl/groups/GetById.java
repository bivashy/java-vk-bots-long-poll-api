package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.response.GenericResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>groups.getById</b> method.
 * <p>
 * Returns information about communities by their IDs.
 *
 * @see <a href="https://vk.com/dev/groups.getById">https://vk.com/dev/groups.getById</a>
 */
public class GetById extends AuthorizedVkApiMethod<GetById.Response> {
    public GetById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getById");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetById setGroupIds(Integer... groupIds) {
        return setGroupIds(Arrays.asList(groupIds));
    }

    public GetById setGroupIds(List<Integer> groupIds) {
        return addParam("group_ids", groupIds);
    }

    public GetById setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetById setFields(List<String> fields) {
        return addParam("fields", fields);
    }

    @Override
    public GetById addParam(String key, Object value) {
        return (GetById) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getById</b> request.
     */
    public static class Response extends GenericResponse<List<Community>> {
    }
}
