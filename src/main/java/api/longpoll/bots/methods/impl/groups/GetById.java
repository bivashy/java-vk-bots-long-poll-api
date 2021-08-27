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

    public GetById setGroupIds(String... groupIds) {
        return setGroupIds(Arrays.asList(groupIds));
    }

    public GetById setGroupIds(List<String> groupIds) {
        addParam("group_ids", groupIds);
        return this;
    }

    public GetById setGroupId(String groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public GetById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetById setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    /**
     * Response to <b>groups.getById</b> request.
     */
    public static class Response extends GenericResponse<List<Community>> {
    }
}
